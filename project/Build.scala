import sbt._
import Keys._

object Struthio extends Build {
  val sharedSettings = Seq(
    scalaVersion := "2.10.1",
    crossScalaVersions := Seq("2.9.2", "2.10.1"),
    organization := "com.mosesn"
  )

  lazy val struthio = Project(
    id = "struthio",
    base = file(".")
  )
    .aggregate(core, thrift)
    .settings(sharedSettings: _*)

  def quickProject(string: String): Project = {
    val name = "struthio-%s" format string
    Project(
      id = name,
      base = file(name)
    )
  }

  lazy val core = quickProject("core")
    .settings(libraryDependencies ++= Seq(
      "com.twitter" %% "ostrich" % "9.1.0" cross CrossVersion.binary
    ))
    .settings(sharedSettings: _*)
    .dependsOn(thrift)

  lazy val thrift = quickProject("thrift")
    .settings(sharedSettings: _*)
    .settings(libraryDependencies ++= Seq(
      "com.twitter" %% "scrooge-runtime" % "3.1.1" cross CrossVersion.binary
    ))
}
