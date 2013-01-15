name := "PivoTool"

organization := "com.gmail.ikeike443"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.9.2"

resolvers ++= Seq(
  "typesafe" at "http://repo.typesafe.com/typesafe/releases",
  "Sonatype OSS" at "https://oss.sonatype.org/content/repositories/releases")

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "1.12" % "test",
    "play" %% "play" % "[2,)" % "provided",
  "play" %% "play-test" % "[2,)" % "test"
)

initialCommands := "import com.gmail.ikeike443.pivotool._"