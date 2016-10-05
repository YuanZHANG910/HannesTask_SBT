
name := "HannesTask_SBT"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "3.0.0",
  "org.scalatest" %% "scalatest" % "3.0.0" % "test"
    exclude("org.scala-lang.modules", "scala-xml_2.11"),
  "org.mongodb" %% "casbah" % "3.1.1"
)