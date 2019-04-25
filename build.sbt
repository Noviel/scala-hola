name := "scala-hello"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.0",
  "com.typesafe.akka" %% "akka-http" % "10.0.9"
)

enablePlugins(JavaAppPackaging)