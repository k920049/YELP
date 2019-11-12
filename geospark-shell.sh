#!/usr/bin/env bash
spark-shell --jars /home/root/GeoSpark/geospark-1.2.0.jar,/home/root/GeoSpark/geospark-sql_2.3-1.2.0.jar,/home/root/GeoSpark/geospark-viz_2.3-1.2.0.jar \
    --conf spark.serializer=org.apache.spark.serializer.KryoSerializer \
    --conf spark.kryo.registrator=org.datasyslab.geospark.serde.GeoSparkKryoRegistrator