name := "esgi-spark-streaming"

version := "1.0"

scalaVersion := "2.11.12"

resolvers += "spark-packages" at "https://dl.bintray.com/spark-packages/maven/"

val SPARK_VERSION = "2.3.1"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % SPARK_VERSION,
  "org.apache.spark" %% "spark-sql" % SPARK_VERSION,
  "org.apache.spark" %% "spark-streaming" % SPARK_VERSION,
  "com.typesafe.play" %% "play-json" % "2.7.2"
)

dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-core" % "2.9.8"
dependencyOverrides += "com.fasterxml.jackson.core" % "jackson-databind" % "2.9.8"
dependencyOverrides += "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.9.8"


scalacOptions in ThisBuild ++= Seq("-J-Xss8M")

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs@_*) =>
    xs map {
      _.toLowerCase
    } match {
      case ("manifest.mf" :: Nil) | ("index.list" :: Nil) | ("dependencies" :: Nil) => MergeStrategy.discard
      case _ => MergeStrategy.discard
    }
  case "conf/application.conf" => MergeStrategy.concat
  case _ => MergeStrategy.first
}

test in assembly := {}
parallelExecution in Test := false