import sbt._
package object dependencies {
  object Version {

    val akka = "2.5.26"
    val akkaHttp = "10.1.5"
    val scalaTestVersion = "3.0.1"

  }

  object Library {

    val scalaTest = "org.scalatest"  %% "scalatest"         % Version.scalaTestVersion % "test"
    //  "org.scalatest" %% "scalatest" % "3.0.8" % Test,
    val akkaActor         = "com.typesafe.akka" %% "akka-actor"           % Version.akka
    val akkaStream        = "com.typesafe.akka" %% "akka-stream"          % Version.akka
    val akkaSlf4j         = "com.typesafe.akka" %% "akka-slf4j"           % Version.akka
    val akkaHTTP          = "com.typesafe.akka" %% "akka-http"            % Version.akkaHttp
    val akkaHTTPTestKit   = "com.typesafe.akka" %% "akka-http-testkit"    % Version.akkaHttp
    val akkaStreamTestKit = "com.typesafe.akka" %% "akka-stream-testkit"  % Version.akka
    val sprayJson         = "com.typesafe.akka" %% "akka-http-spray-json" % "10.1.10"

  }

  object Dependencies {
    import Library._

    val depends =
      Seq(
        scalaTest,
        akkaActor,
        akkaStream,
        akkaSlf4j,
        akkaHTTP,
        akkaHTTPTestKit,
        akkaStreamTestKit
      )
  }

}
