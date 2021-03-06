import play.sbt.PlayScala

lazy val commonSettings = Seq(
    organization := "com.blackmirror",
    version := "3.0",
    scalaVersion := "2.11.8"
)

libraryDependencies ++= Seq(
    jdbc,
    cache,
    ws,
    "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,
    "org.mongodb.scala" %% "mongo-scala-driver" % "1.2.1",
    "org.mongodb.spark" %% "mongo-spark-connector" % "2.0.0",
    "org.apache.spark" %% "spark-core" % "2.0.0",
    "org.apache.spark" %% "spark-sql" % "2.0.0"
)

lazy val root = (project in file(".")).
    settings(commonSettings: _*).
    settings(
	    routesGenerator := InjectedRoutesGenerator,
        name := "dongda-service",
        fork in run := true,
        javaOptions += "-Xmx5G"
    ).enablePlugins(PlayScala)
