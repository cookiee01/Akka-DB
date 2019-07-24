name := "akka-db"
organization := "com.akkademy-db"
version := "0.0.1-SNAPSHOT"
scalaVersion := "2.12.6"
lazy val akkaVersion = "2.6.0-M4"
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
  "org.scalatest" %% "scalatest" % "3.0.5" % "test"
  "com.typesafe.akka" %% "akka-remote" % akkaVersion,
)
mappings in (Compile, packageBin) ~= { _.filterNot { case (_, name) =>
Seq("application.conf").contains(name)
}}