package com.mosesn.struthio

import com.twitter.ostrich.admin.{StatsReporterFactory, AdminHttpService, Service => OstrichService, PeriodicBackgroundProcess}
import com.twitter.ostrich.stats.{StatsCollection, StatsListener, Distribution => OstrichDistribution}
import com.twitter.finagle.{Service => FinagleService, ServiceFactory, Group}
import java.net.SocketAddress
import com.twitter.finagle.stats.StatsReceiver
import com.mosesn.struthio.thrift.{StatsService, Distribution => ThriftDistribution}
import com.twitter.finagle.thrift.ThriftClientRequest
import com.twitter.finagle.Thrift
import com.twitter.util.TimeConversions.intToTimeableNumber
import com.twitter.util.{Await, Future}

class StruthioStatsReporterFactory(receiver: StatsReceiver, group: Group[SocketAddress]) extends StatsReporterFactory {
  override def apply(collection: StatsCollection, ostrich: AdminHttpService): OstrichService = {
    new StruthioStatsReporter(collection, group, receiver)
  }
}

class StruthioStatsReporter(
  collection: StatsCollection,
  group: Group[SocketAddress],
  receiver: StatsReceiver
) extends PeriodicBackgroundProcess("struthio", 1.minutes, true) {
  val listener = new StatsListener(collection)
  val factory: ServiceFactory[ThriftClientRequest, Array[Byte]] = Thrift.newClient(group)
  val service = Await.result(factory())
  val client = new StatsService.FinagledClient(service, serviceName = "struthio", stats = receiver)

  override def periodic() {
    val stats = listener.get()
    val sendings = Seq(
      client.syncCounters(stats.counters),
      client.syncMetrics(stats.metrics map {
        case (key, distribution) => (key, distribution.asThrift)
      }),
      client.syncGauges(stats.gauges),
      client.syncLabels(stats.labels)
    )
    Future.join(sendings)
  }

  private[this] implicit def distriubtionWrapper(ostrich: OstrichDistribution): OstrichToThrift = new OstrichToThrift(ostrich)

  override def shutdown() {
    Await.result(service.close())
    Await.result(factory.close())
    super.shutdown()
  }
}

class OstrichToThrift(ostrich: OstrichDistribution) {
  def asThrift: ThriftDistribution = {
    val histo = ostrich.histogram
    ThriftDistribution(histo.buckets, histo.count, histo.sum)
  }
}
