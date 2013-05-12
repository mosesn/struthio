/**
 * generated by Scrooge 3.1.1
 */
package com.mosesn.struthio.thrift

import com.twitter.scrooge.{ThriftStruct, ThriftStructCodec, ThriftStructCodec3}
import java.net.InetSocketAddress
import java.nio.ByteBuffer
import org.apache.thrift.protocol._
import org.apache.thrift.TApplicationException
import scala.collection.mutable
import scala.collection.{Map, Set}
import com.twitter.util.Future
import com.twitter.conversions.time._
import com.twitter.finagle.{Service => FinagleService}
import com.twitter.finagle.stats.{NullStatsReceiver, StatsReceiver}
import com.twitter.finagle.thrift.ThriftClientRequest
import com.twitter.finagle.SourcedException
import com.twitter.finagle.{Service => FinagleService}
import java.util.Arrays
import org.apache.thrift.transport.{TMemoryBuffer, TMemoryInputTransport, TTransport}


@javax.annotation.Generated(value = Array("com.twitter.scrooge.Compiler"), date = "2013-05-12T19:13:04.941-0400")
object StatsService {
  trait Iface {
    
    def sendStats(stats: Map[String, Double] = Map[String, Double]()): Unit
    
    def sendStatuses(statuses: Map[String, String] = Map[String, String]()): Unit
  }

  trait FutureIface {
    
    def sendStats(stats: Map[String, Double] = Map[String, Double]()): Future[Unit]
    
    def sendStatuses(statuses: Map[String, String] = Map[String, String]()): Future[Unit]
  }

  
  object sendStats$args extends ThriftStructCodec3[sendStats$args] {
    val Struct = new TStruct("sendStats_args")
    val StatsField = new TField("stats", TType.MAP, 1)
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate(_item: sendStats$args) {
    }
  
    override def encode(_item: sendStats$args, _oproto: TProtocol) { _item.write(_oproto) }
    override def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): sendStats$args = decode(_iprot)
  
    def apply(
      stats: Map[String, Double] = Map[String, Double]()
    ): sendStats$args = new Immutable(
      stats
    )
  
    def unapply(_item: sendStats$args): Option[Map[String, Double]] = Some(_item.stats)
  
    object Immutable extends ThriftStructCodec3[sendStats$args] {
      override def encode(_item: sendStats$args, _oproto: TProtocol) { _item.write(_oproto) }
      override def decode(_iprot: TProtocol) = {
        var stats: Map[String, Double] = Map[String, Double]()
        var _got_stats = false
        var _done = false
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case 1 => { /* stats */
                _field.`type` match {
                  case TType.MAP => {
                    stats = {
                      val _map = _iprot.readMapBegin()
                      val _rv = new mutable.HashMap[String, Double]
                      var _i = 0
                      while (_i < _map.size) {
                        val _key = {
                          _iprot.readString()
                        }
                        val _value = {
                          _iprot.readDouble()
                        }
                        _rv(_key) = _value
                        _i += 1
                      }
                      _iprot.readMapEnd()
                      _rv
                    }
                    _got_stats = true
                  }
                  case _ => TProtocolUtil.skip(_iprot, _field.`type`)
                }
              }
              case _ => TProtocolUtil.skip(_iprot, _field.`type`)
            }
            _iprot.readFieldEnd()
          }
        }
        _iprot.readStructEnd()
        new Immutable(
          stats
        )
      }
    }
  
    /**
     * The default read-only implementation of sendStats$args.  You typically should not need to
     * directly reference this class; instead, use the sendStats$args.apply method to construct
     * new instances.
     */
    class Immutable(
      val stats: Map[String, Double] = Map[String, Double]()
    ) extends sendStats$args
  
  }
  
  trait sendStats$args extends ThriftStruct
    with Product1[Map[String, Double]]
    with java.io.Serializable
  {
    import sendStats$args._
  
    def stats: Map[String, Double]
  
    def _1 = stats
  
    override def write(_oprot: TProtocol) {
      sendStats$args.validate(this)
      _oprot.writeStructBegin(Struct)
      if (true) {
        val stats_item = stats
        _oprot.writeFieldBegin(StatsField)
        _oprot.writeMapBegin(new TMap(TType.STRING, TType.DOUBLE, stats_item.size))
        stats_item.foreach { _pair =>
          val stats_item_key = _pair._1
          val stats_item_value = _pair._2
          _oprot.writeString(stats_item_key)
          _oprot.writeDouble(stats_item_value)
        }
        _oprot.writeMapEnd()
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      stats: Map[String, Double] = this.stats
    ): sendStats$args = new Immutable(
      stats
    )
  
    override def canEqual(other: Any): Boolean = other.isInstanceOf[sendStats$args]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
  
    override def productArity: Int = 1
  
    override def productElement(n: Int): Any = n match {
      case 0 => stats
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix: String = "sendStats$args"
  }
  
  object sendStats$result extends ThriftStructCodec3[sendStats$result] {
    val Struct = new TStruct("sendStats_result")
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate(_item: sendStats$result) {
    }
  
    override def encode(_item: sendStats$result, _oproto: TProtocol) { _item.write(_oproto) }
    override def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): sendStats$result = decode(_iprot)
  
    def apply(
    ): sendStats$result = new Immutable(
    )
  
    def unapply(_item: sendStats$result): Boolean = true
  
    object Immutable extends ThriftStructCodec3[sendStats$result] {
      override def encode(_item: sendStats$result, _oproto: TProtocol) { _item.write(_oproto) }
      override def decode(_iprot: TProtocol) = {
        var _done = false
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case _ => TProtocolUtil.skip(_iprot, _field.`type`)
            }
            _iprot.readFieldEnd()
          }
        }
        _iprot.readStructEnd()
        new Immutable(
        )
      }
    }
  
    /**
     * The default read-only implementation of sendStats$result.  You typically should not need to
     * directly reference this class; instead, use the sendStats$result.apply method to construct
     * new instances.
     */
    class Immutable(
    ) extends sendStats$result
  
  }
  
  trait sendStats$result extends ThriftStruct
    with Product
    with java.io.Serializable
  {
    import sendStats$result._
  
  
  
    override def write(_oprot: TProtocol) {
      sendStats$result.validate(this)
      _oprot.writeStructBegin(Struct)
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
    ): sendStats$result = new Immutable(
    )
  
    override def canEqual(other: Any): Boolean = other.isInstanceOf[sendStats$result]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
  
    override def productArity: Int = 0
  
    override def productElement(n: Int): Any = n match {
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix: String = "sendStats$result"
  }
  
  object sendStatuses$args extends ThriftStructCodec3[sendStatuses$args] {
    val Struct = new TStruct("sendStatuses_args")
    val StatusesField = new TField("statuses", TType.MAP, 1)
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate(_item: sendStatuses$args) {
    }
  
    override def encode(_item: sendStatuses$args, _oproto: TProtocol) { _item.write(_oproto) }
    override def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): sendStatuses$args = decode(_iprot)
  
    def apply(
      statuses: Map[String, String] = Map[String, String]()
    ): sendStatuses$args = new Immutable(
      statuses
    )
  
    def unapply(_item: sendStatuses$args): Option[Map[String, String]] = Some(_item.statuses)
  
    object Immutable extends ThriftStructCodec3[sendStatuses$args] {
      override def encode(_item: sendStatuses$args, _oproto: TProtocol) { _item.write(_oproto) }
      override def decode(_iprot: TProtocol) = {
        var statuses: Map[String, String] = Map[String, String]()
        var _got_statuses = false
        var _done = false
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case 1 => { /* statuses */
                _field.`type` match {
                  case TType.MAP => {
                    statuses = {
                      val _map = _iprot.readMapBegin()
                      val _rv = new mutable.HashMap[String, String]
                      var _i = 0
                      while (_i < _map.size) {
                        val _key = {
                          _iprot.readString()
                        }
                        val _value = {
                          _iprot.readString()
                        }
                        _rv(_key) = _value
                        _i += 1
                      }
                      _iprot.readMapEnd()
                      _rv
                    }
                    _got_statuses = true
                  }
                  case _ => TProtocolUtil.skip(_iprot, _field.`type`)
                }
              }
              case _ => TProtocolUtil.skip(_iprot, _field.`type`)
            }
            _iprot.readFieldEnd()
          }
        }
        _iprot.readStructEnd()
        new Immutable(
          statuses
        )
      }
    }
  
    /**
     * The default read-only implementation of sendStatuses$args.  You typically should not need to
     * directly reference this class; instead, use the sendStatuses$args.apply method to construct
     * new instances.
     */
    class Immutable(
      val statuses: Map[String, String] = Map[String, String]()
    ) extends sendStatuses$args
  
  }
  
  trait sendStatuses$args extends ThriftStruct
    with Product1[Map[String, String]]
    with java.io.Serializable
  {
    import sendStatuses$args._
  
    def statuses: Map[String, String]
  
    def _1 = statuses
  
    override def write(_oprot: TProtocol) {
      sendStatuses$args.validate(this)
      _oprot.writeStructBegin(Struct)
      if (true) {
        val statuses_item = statuses
        _oprot.writeFieldBegin(StatusesField)
        _oprot.writeMapBegin(new TMap(TType.STRING, TType.STRING, statuses_item.size))
        statuses_item.foreach { _pair =>
          val statuses_item_key = _pair._1
          val statuses_item_value = _pair._2
          _oprot.writeString(statuses_item_key)
          _oprot.writeString(statuses_item_value)
        }
        _oprot.writeMapEnd()
        _oprot.writeFieldEnd()
      }
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
      statuses: Map[String, String] = this.statuses
    ): sendStatuses$args = new Immutable(
      statuses
    )
  
    override def canEqual(other: Any): Boolean = other.isInstanceOf[sendStatuses$args]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
  
    override def productArity: Int = 1
  
    override def productElement(n: Int): Any = n match {
      case 0 => statuses
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix: String = "sendStatuses$args"
  }
  
  object sendStatuses$result extends ThriftStructCodec3[sendStatuses$result] {
    val Struct = new TStruct("sendStatuses_result")
  
    /**
     * Checks that all required fields are non-null.
     */
    def validate(_item: sendStatuses$result) {
    }
  
    override def encode(_item: sendStatuses$result, _oproto: TProtocol) { _item.write(_oproto) }
    override def decode(_iprot: TProtocol) = Immutable.decode(_iprot)
  
    def apply(_iprot: TProtocol): sendStatuses$result = decode(_iprot)
  
    def apply(
    ): sendStatuses$result = new Immutable(
    )
  
    def unapply(_item: sendStatuses$result): Boolean = true
  
    object Immutable extends ThriftStructCodec3[sendStatuses$result] {
      override def encode(_item: sendStatuses$result, _oproto: TProtocol) { _item.write(_oproto) }
      override def decode(_iprot: TProtocol) = {
        var _done = false
        _iprot.readStructBegin()
        while (!_done) {
          val _field = _iprot.readFieldBegin()
          if (_field.`type` == TType.STOP) {
            _done = true
          } else {
            _field.id match {
              case _ => TProtocolUtil.skip(_iprot, _field.`type`)
            }
            _iprot.readFieldEnd()
          }
        }
        _iprot.readStructEnd()
        new Immutable(
        )
      }
    }
  
    /**
     * The default read-only implementation of sendStatuses$result.  You typically should not need to
     * directly reference this class; instead, use the sendStatuses$result.apply method to construct
     * new instances.
     */
    class Immutable(
    ) extends sendStatuses$result
  
  }
  
  trait sendStatuses$result extends ThriftStruct
    with Product
    with java.io.Serializable
  {
    import sendStatuses$result._
  
  
  
    override def write(_oprot: TProtocol) {
      sendStatuses$result.validate(this)
      _oprot.writeStructBegin(Struct)
      _oprot.writeFieldStop()
      _oprot.writeStructEnd()
    }
  
    def copy(
    ): sendStatuses$result = new Immutable(
    )
  
    override def canEqual(other: Any): Boolean = other.isInstanceOf[sendStatuses$result]
  
    override def equals(other: Any): Boolean = runtime.ScalaRunTime._equals(this, other)
  
    override def hashCode: Int = runtime.ScalaRunTime._hashCode(this)
  
    override def toString: String = runtime.ScalaRunTime._toString(this)
  
  
    override def productArity: Int = 0
  
    override def productElement(n: Int): Any = n match {
      case _ => throw new IndexOutOfBoundsException(n.toString)
    }
  
    override def productPrefix: String = "sendStatuses$result"
  }

  
  class FinagledClient(
    val service: FinagleService[ThriftClientRequest, Array[Byte]],
    val protocolFactory: TProtocolFactory = new TBinaryProtocol.Factory,
    val serviceName: String = "",
    stats: StatsReceiver = NullStatsReceiver
  ) extends FutureIface {
    // ----- boilerplate that should eventually be moved into finagle:
  
    protected def encodeRequest(name: String, args: ThriftStruct) = {
      val buf = new TMemoryBuffer(512)
      val oprot = protocolFactory.getProtocol(buf)
  
      oprot.writeMessageBegin(new TMessage(name, TMessageType.CALL, 0))
      args.write(oprot)
      oprot.writeMessageEnd()
  
      val bytes = Arrays.copyOfRange(buf.getArray, 0, buf.length)
      new ThriftClientRequest(bytes, false)
    }
  
    protected def decodeResponse[T <: ThriftStruct](resBytes: Array[Byte], codec: ThriftStructCodec[T]) = {
      val iprot = protocolFactory.getProtocol(new TMemoryInputTransport(resBytes))
      val msg = iprot.readMessageBegin()
      try {
        if (msg.`type` == TMessageType.EXCEPTION) {
          val exception = TApplicationException.read(iprot) match {
            case sourced: SourcedException =>
              if (serviceName != "") sourced.serviceName = serviceName
              sourced
            case e => e
          }
          throw exception
        } else {
          codec.decode(iprot)
        }
      } finally {
        iprot.readMessageEnd()
      }
    }
  
    protected def missingResult(name: String) = {
      new TApplicationException(
        TApplicationException.MISSING_RESULT,
        name + " failed: unknown result"
      )
    }
  
    // ----- end boilerplate.
  
    private[this] val scopedStats = if (serviceName != "") stats.scope(serviceName) else stats
    private[this] object __stats_sendStats {
      val RequestsCounter = scopedStats.scope("sendStats").counter("requests")
      val SuccessCounter = scopedStats.scope("sendStats").counter("success")
      val FailuresCounter = scopedStats.scope("sendStats").counter("failures")
      val FailuresScope = scopedStats.scope("sendStats").scope("failures")
    }
  
  
    def sendStats(stats: Map[String, Double] = Map[String, Double]()): Future[Unit] = {
      __stats_sendStats.RequestsCounter.incr()
      this.service(encodeRequest("sendStats", sendStats$args(stats))) flatMap { response =>
        val result = decodeResponse(response, sendStats$result)
        val exception =
          None
        exception.getOrElse(Future.Done)
      } rescue {
        case ex: SourcedException => {
          if (this.serviceName != "") { ex.serviceName = this.serviceName }
          Future.exception(ex)
        }
      } onSuccess { _ =>
        __stats_sendStats.SuccessCounter.incr()
      } onFailure { ex =>
        __stats_sendStats.FailuresCounter.incr()
        __stats_sendStats.FailuresScope.counter(ex.getClass.getName).incr()
      }
    }
    private[this] object __stats_sendStatuses {
      val RequestsCounter = scopedStats.scope("sendStatuses").counter("requests")
      val SuccessCounter = scopedStats.scope("sendStatuses").counter("success")
      val FailuresCounter = scopedStats.scope("sendStatuses").counter("failures")
      val FailuresScope = scopedStats.scope("sendStatuses").scope("failures")
    }
  
  
    def sendStatuses(statuses: Map[String, String] = Map[String, String]()): Future[Unit] = {
      __stats_sendStatuses.RequestsCounter.incr()
      this.service(encodeRequest("sendStatuses", sendStatuses$args(statuses))) flatMap { response =>
        val result = decodeResponse(response, sendStatuses$result)
        val exception =
          None
        exception.getOrElse(Future.Done)
      } rescue {
        case ex: SourcedException => {
          if (this.serviceName != "") { ex.serviceName = this.serviceName }
          Future.exception(ex)
        }
      } onSuccess { _ =>
        __stats_sendStatuses.SuccessCounter.incr()
      } onFailure { ex =>
        __stats_sendStatuses.FailuresCounter.incr()
        __stats_sendStatuses.FailuresScope.counter(ex.getClass.getName).incr()
      }
    }
  }
  
  class FinagledService(
    iface: FutureIface,
    protocolFactory: TProtocolFactory
  ) extends FinagleService[Array[Byte], Array[Byte]] {
    // ----- boilerplate that should eventually be moved into finagle:
  
    protected val functionMap = new mutable.HashMap[String, (TProtocol, Int) => Future[Array[Byte]]]()
  
    protected def addFunction(name: String, f: (TProtocol, Int) => Future[Array[Byte]]) {
      functionMap(name) = f
    }
  
    protected def exception(name: String, seqid: Int, code: Int, message: String): Future[Array[Byte]] = {
      try {
        val x = new TApplicationException(code, message)
        val memoryBuffer = new TMemoryBuffer(512)
        val oprot = protocolFactory.getProtocol(memoryBuffer)
  
        oprot.writeMessageBegin(new TMessage(name, TMessageType.EXCEPTION, seqid))
        x.write(oprot)
        oprot.writeMessageEnd()
        oprot.getTransport().flush()
        Future.value(Arrays.copyOfRange(memoryBuffer.getArray(), 0, memoryBuffer.length()))
      } catch {
        case e: Exception => Future.exception(e)
      }
    }
  
    protected def reply(name: String, seqid: Int, result: ThriftStruct): Future[Array[Byte]] = {
      try {
        val memoryBuffer = new TMemoryBuffer(512)
        val oprot = protocolFactory.getProtocol(memoryBuffer)
  
        oprot.writeMessageBegin(new TMessage(name, TMessageType.REPLY, seqid))
        result.write(oprot)
        oprot.writeMessageEnd()
  
        Future.value(Arrays.copyOfRange(memoryBuffer.getArray(), 0, memoryBuffer.length()))
      } catch {
        case e: Exception => Future.exception(e)
      }
    }
  
    final def apply(request: Array[Byte]): Future[Array[Byte]] = {
      val inputTransport = new TMemoryInputTransport(request)
      val iprot = protocolFactory.getProtocol(inputTransport)
  
      try {
        val msg = iprot.readMessageBegin()
        functionMap.get(msg.name) map { _.apply(iprot, msg.seqid) } getOrElse {
          TProtocolUtil.skip(iprot, TType.STRUCT)
          exception(msg.name, msg.seqid, TApplicationException.UNKNOWN_METHOD,
            "Invalid method name: '" + msg.name + "'")
        }
      } catch {
        case e: Exception => Future.exception(e)
      }
    }
  
    // ---- end boilerplate.
  
    addFunction("sendStats", { (iprot: TProtocol, seqid: Int) =>
      try {
        val args = sendStats$args.decode(iprot)
        iprot.readMessageEnd()
        (try {
          iface.sendStats(args.stats)
        } catch {
          case e: Exception => Future.exception(e)
        }) flatMap { value: Unit =>
          reply("sendStats", seqid, sendStats$result())
        } rescue {
          case e => Future.exception(e)
        }
      } catch {
        case e: TProtocolException => {
          iprot.readMessageEnd()
          exception("sendStats", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage)
        }
        case e: Exception => Future.exception(e)
      }
    })
    addFunction("sendStatuses", { (iprot: TProtocol, seqid: Int) =>
      try {
        val args = sendStatuses$args.decode(iprot)
        iprot.readMessageEnd()
        (try {
          iface.sendStatuses(args.statuses)
        } catch {
          case e: Exception => Future.exception(e)
        }) flatMap { value: Unit =>
          reply("sendStatuses", seqid, sendStatuses$result())
        } rescue {
          case e => Future.exception(e)
        }
      } catch {
        case e: TProtocolException => {
          iprot.readMessageEnd()
          exception("sendStatuses", seqid, TApplicationException.PROTOCOL_ERROR, e.getMessage)
        }
        case e: Exception => Future.exception(e)
      }
    })
  }
}