import sbt._

object Dependencies {

    val slf4jVersion = "1.7.20"
    val logbackVersion = "1.2.3"
    val junitVersion = "4.12"
    val junitInterfaceVersion = "0.11"
    val jsoupVersion = "1.7.3"
    val betterFilesVersion = "3.8.0"
    val commonsIoVersion = "2.0.1"
    val scalaParserCombinatorsVersion = "1.1.2"
    val httpClientVersion = "4.5.9"
    val commonsLangVersion = "2.6"


    val logging = Seq( "org.slf4j" % "slf4j-api" % slf4jVersion,
                       "ch.qos.logback" % "logback-classic" % logbackVersion )

    val junit = Seq( "junit" % "junit" % junitVersion % "test",
                     "com.novocode" % "junit-interface" % junitInterfaceVersion % "test" )

    val jsoup = Seq( "org.jsoup" % "jsoup" % jsoupVersion )

    val commonsIo = Seq( "commons-io" % "commons-io" % commonsIoVersion )

    val scalaParserCombinators = Seq( "org.scala-lang.modules" %% "scala-parser-combinators" % scalaParserCombinatorsVersion )

    val httpClient = Seq( "org.apache.httpcomponents" % "httpclient" % httpClientVersion )

    val commonsLang = Seq( "commons-lang" % "commons-lang" % commonsLangVersion )
}