package com.mosesn.struthio

import com.mosesn.struthio.thrift.{StatsService, Distribution => StruthioDistribution}
import com.twitter.util.Future
import scala.collection.Map
import com.twitter.finagle.ClientConnection
import com.twitter.ostrich.stats.{Stats, Distribution => OstrichDistribution, Histogram}

class Struthio(conn: ClientConnection) extends StatsService.FutureIface {
  override def syncCounters(counters: Map[String, Long]): Future[Unit] =
    Future(for ((name, value) <- counters) {
      Stats.incr("%s.%s".format(conn.remoteAddress.toString, name), value.toInt)
      Stats.incr(name, value.toInt)
    })

  override def syncGauges(gauges: Map[String, Double]): Future[Unit] =
    Future(for ((name, value) <- gauges) {
      Stats.setGauge("%s.%s".format(conn.remoteAddress.toString, name), value)
    })

  override def syncLabels(labels: Map[String, String]): Future[Unit] =
    Future(for ((name, label) <- labels) {
      Stats.setLabel("%s.%s".format(conn.remoteAddress.toString, name), label)
    })

  override def syncMetrics(metrics: Map[String, StruthioDistribution]): Future[Unit] =
    Future(for ((name, distribution) <- metrics) {
      Stats.addMetric("%s.%s".format(conn.remoteAddress.toString, name), toTwitter(distribution))
    })

  private[this] def toTwitter(struthDist: StruthioDistribution): OstrichDistribution = {
    new OstrichDistribution(new Histogram() {
      override val buckets = struthDist.buckets.toArray
      count = struthDist.count
      sum = struthDist.sum
    })
  }
}
