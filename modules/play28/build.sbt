/**
 * File     : build.sbt
 * License  :
 *   The MIT License (MIT)
 *
 *   Original   - Copyright (c) 2014 Jöerg Viola, Marco Sinigaglia
 *   Derivative - Copyright (c) 2016 - 2020 play2-scala-pdf Contributors
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in all
 *   copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *   SOFTWARE.
 */
import scala.io.Source

name := """play28-scala-pdf"""

organization := "com.hhandoko"

version := Source.fromFile("../../VERSION.txt").mkString.trim

scalaVersion := "2.12.2"

crossScalaVersions := Seq("2.12.12", "2.13.3")

libraryDependencies ++= Seq(
  guice,

  // Scala 2.13 Collection compatibility
  //   - https://github.com/scala/scala-collection-compat
  "org.scala-lang.modules" %% "scala-collection-compat" % "2.1.6",

  // Apache Commons IO
  //   - https://commons.apache.org/proper/commons-io/
  "commons-io" % "commons-io" % "2.6",

  // HTML parsing + PDF generation
  //   - http://jtidy.sourceforge.net/
  //   - https://github.com/flyingsaucerproject/flyingsaucer
  //   - https://about.validator.nu/htmlparser/
  //   - https://jsoup.org/
  "net.sf.jtidy" % "jtidy" % "r938",
  "org.xhtmlrenderer" % "flying-saucer-pdf-openpdf" % "9.1.14",
  "nu.validator.htmlparser" % "htmlparser" % "1.4",
  "org.jsoup" % "jsoup" % "1.11.3" % Test,

  // ScalaTest + Play plugin
  //   - http://www.scalatest.org/plus/play
  "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % Test
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

lazy val play28 = (project in file(".")).enablePlugins(PlayScala)
