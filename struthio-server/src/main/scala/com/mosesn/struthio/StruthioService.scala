package com.mosesn.struthio

import com.twitter.ostrich.admin.{Service => OstrichService}
import com.twitter.finagle.{Service => FinagleService, ClientConnection, ServiceFactory}
import com.twitter.finagle.builder.{ServerBuilder, Server}
import com.twitter.finagle.thrift.ThriftServerFramedCodec
import com.twitter.finagle.stats.StatsReceiver
import java.net.InetSocketAddress
import com.mosesn.struthio.thrift.StatsService
import org.apache.thrift.protocol.TBinaryProtocol
import com.twitter.util.{Future, Time}

class StruthioService(
  port: Int,
  statsReceiver: StatsReceiver,
  struthio: ClientConnection => StatsService.FutureIface
) extends OstrichService {
  var server: Option[Server] = None

  val factory = new ServiceFactory[Array[Byte], Array[Byte]] {
    override def apply(conn: ClientConnection): Future[FinagleService[Array[Byte], Array[Byte]]] =
      Future(new StatsService.FinagledService(struthio(conn), new TBinaryProtocol.Factory()))

    override def close(deadline: Time): Future[Unit] = {
      ???
    }
  }

  override def start() {
    server = Some(ServerBuilder()
      .name("struthio")
      .maxConcurrentRequests(1024)
      .codec(ThriftServerFramedCodec())
      .reportTo(statsReceiver)
      .bindTo(new InetSocketAddress(port))
      .build(factory))
  }

  override def shutdown() {
    server.getOrElse(throw new Exception("cannot close before the server is started")).close()
  }
}
