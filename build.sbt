sbtPlugin := true

name := "sbt-s3-resolver"
organization := "com.deere.stratum"
description := "SBT plugin which provides Amazon S3 bucket resolvers"

javaVersion := "1.7"
scalaVersion := "2.10.6"

bucketSuffix := "era7.com"

libraryDependencies += "ohnosequences" % "ivy-s3-resolver" % "0.9.0"

wartremoverErrors in (Compile, compile) --= Seq(Wart.Any, Wart.NonUnitStatements)

publishTo := {
  val nexus = "http://isgnexus.deere.com/nexus/content/repositories"
  if (version.value.contains("-SNAPSHOT"))
    Some("ISG Snapshots" at nexus + "/snapshots")
  else
    Some("ISG Releases" at nexus + "/releases")
}