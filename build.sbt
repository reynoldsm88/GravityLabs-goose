import Dependencies._
import sbt._

organization := "com.gravity"
name := "goose"
version := "2.1.30-SNAPSHOT"
scalaVersion in ThisBuild := "2.12.7"

resolvers in ThisBuild ++= Seq( "Sonatype releases" at "https://oss.sonatype.org/content/repositories/releases",
                                "Spray IO Repository" at "http://repo.spray.io/",
                                "Maven Central" at "https://repo1.maven.org/maven2/",
                                "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
                                "JCenter" at "http://jcenter.bintray.com",
                                "Local Ivy Repository" at s"file://${System.getProperty( "user.home" )}/.ivy2/local/default" )

publishTo in ThisBuild := {
    if ( isSnapshot.value ) Some( "Cause Ex Nexus Repository Snapshots" at "https://nexus.causeex.com/repository/maven" )
    else Some( "Cause Ex Nexus Repository Releases" at "https://nexus.causeex.com/repository/maven/" )
}

lazy val root = ( project in file( "." ) ).settings( libraryDependencies ++= logging
                                                                             ++ jsoup
                                                                             ++ httpClient
                                                                             ++ commonsLang
                                                                             ++ commonsIo
                                                                             ++ scalaParserCombinators
                                                                             ++ junit )