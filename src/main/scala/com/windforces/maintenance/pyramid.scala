package com.windforces.maintenance

import org.apache.spark.sql.SparkSession
import org.apache.spark.serializer.KryoSerializer
import org.datasyslab.geospark.serde.GeoSparkKryoRegistrator
import org.datasyslab.geospark.spatialRDD.SpatialRDD
import org.datasyslab.geosparksql.utils.{Adapter, GeoSparkSQLRegistrator}
import org.datasyslab.geospark.enums.GridType

import com.vividsolutions.jts.geom.Geometry

object pyramid {
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

        val business_df = spark.read.format("json").option("mode", "FAILFAST").option("inferSchema", "true").load("hdfs:///user/root/YELP/data/restaurant/yelp_academic_dataset_business.json")
        val canonical_business_df = business_df.select("business_id", "latitude", "longitude")
        canonical_business_df.createOrReplaceTempView("canonical_business")
        var spatialDf = spark.sql(
            """
               SELECT ST_Point(CAST(canonical_business.latitude AS Decimal(24,20)), CAST(canonical_business.longitude AS Decimal(24,20))) AS business_location, business_id
               FROM canonical_business
            """.stripMargin)

        var spatialRDD = new SpatialRDD[Geometry]
        spatialRDD.rawSpatialRDD = Adapter.toRdd(spatialDf)
        spatialRDD.spatialPartitioning(GridType.QUADTREE)
    }
}
