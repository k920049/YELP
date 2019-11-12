// Package Information
name := "YELP"
version := "0.1.4"
scalaVersion := "2.11.8"
organization := "com.windforces" // change to your org


// Spark Information
val sparkVersion = "2.3.1"

// allows us to include spark packages
resolvers += "bintray-spark-packages" at "https://dl.bintray.com/spark-packages/maven/"
resolvers += "Typesafe Simple Repository" at "http://repo.typesafe.com/typesafe/simple/maven-releases/"
resolvers += "MavenRepository" at "https://mvnrepository.com/"

libraryDependencies ++= Seq(
    // spark core
    "org.apache.spark" %% "spark-core" % sparkVersion,
    "org.apache.spark" %% "spark-sql" % sparkVersion,

    // spark-modules
    "org.apache.spark" %% "spark-graphx" % sparkVersion,
    "org.apache.spark" %% "spark-mllib" % sparkVersion,
    "org.datasyslab" %% "geospark" % "1.2.0" from "file:///Users/jeasungpark/Repository/YELP/lib/geospark_2.11-1.2.0.jar",
    "org.datasyslab" %% "geospark-sql" % "1.2.0" from "file:///Users/jeasungpark/Repository/YELP/lib/geospark-sql_2.11-1.2.0.jar",
    "org.datasyslab" %% "geospark-viz" % "1.2.0" from "file:///Users/jeasungpark/Repository/YELP/lib/geospark-viz_2.11-1.2.0.jar"
)