package com.windforces.example

import com.vividsolutions.jts.geom.Geometry
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.serializer.KryoSerializer
import org.datasyslab.geospark.serde.GeoSparkKryoRegistrator
import org.datasyslab.geosparksql.utils.GeoSparkSQLRegistrator


object testRDD {
    def main(args: Array[String]): Unit = {

        val spark = SparkSession.builder()
            .appName("GeoSpark Runnable Example")
            .master("yarn")
            .config("spark.serializer", classOf[KryoSerializer].getName)
            .config("spark.kryo.registrator", classOf[GeoSparkKryoRegistrator].getName)
            .enableHiveSupport()
            .getOrCreate()
        val sc = spark.sparkContext
        GeoSparkSQLRegistrator.registerAll(spark)

        println(classOf[KryoSerializer].getName())
        println(classOf[GeoSparkKryoRegistrator].getName())

    }
}
