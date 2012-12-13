organization := "com.jtm"

name := "domain-project"

version := "0.1"

scalaVersion := "2.9.2"

libraryDependencies ++= List(
    "org.squeryl" %% "squeryl" % "0.9.5-2",
    "postgresql" % "postgresql" % "8.4-701.jdbc4",
    "ch.qos.logback" % "logback-classic" % "1.0.6",
	"org.slf4j" % "slf4j-api" % "1.6.4",
	"com.h2database" % "h2" % "1.3.166",
	"org.scalatest" %% "scalatest" % "1.6.1" % "test"
)


