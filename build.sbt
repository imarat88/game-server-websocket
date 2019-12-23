import dependencies.Dependencies
name := "game-server-websocket"

version := "0.1"

scalaVersion := "2.12.8"



credentials   += Credentials(Path.userHome / ".sbt" / ".credentials")
//libraryDependencies ++= Seq(
//  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
//  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
//  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
//  "com.typesafe.akka" %% "akka-slf4j"  % akkaVersion,
//
//  "com.typesafe.akka" %% "akka-http-core" % akkaHttpVersion,
//
//  "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test",
//  "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion % "test",
//  "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % "test",
//  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
//
//  "com.typesafe.akka" %% "akka-http-spray-json" % "10.1.10",
//
//)

enablePlugins(JavaAppPackaging)
packageName in Universal :="app"

libraryDependencies :=Dependencies.depends

Test / parallelExecution :=false