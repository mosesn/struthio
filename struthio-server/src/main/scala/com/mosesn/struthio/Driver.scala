package com.mosesn.struthio

import com.twitter.ostrich.admin.{AdminServiceFactory, RuntimeEnvironment, ServiceTracker, Service}
import com.twitter.logging.Logger

object Driver {
  val log = Logger.get(getClass.getName)

  def main(args: Array[String]) {
    try {
      val env = new RuntimeEnvironment(this, args)
      startAdmin(env, 9900)
      startStruthio(env)
      ServiceTracker.shutdown()
    } catch {
      case e: Throwable =>
        handleStartupError(e)
    }
  }

  def handleStartupError(e: Throwable) {
    log.error(e, "there was an error while starting up")
    log.warning("shutting down services")
    ServiceTracker.shutdown()
    log.warning("shut down services")
  }

  def startAdmin(env: RuntimeEnvironment, port: Int) {
    log.warning("starting up admin service")
    val admin = AdminServiceFactory(port)(env)
    log.warning("started up admin service")
  }

  def startStruthio(env: RuntimeEnvironment) {
    log.warning("starting up struthio server")
    val server = env.loadConfig[Service]
    server.start()
    log.warning("started up struthio server")
    ServiceTracker.register(server)
  }
}
