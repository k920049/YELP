#!/usr/bin/env bash
spark-submit \
    --master "yarn" \
    --deploy-mode "cluster" \
    --class "com.windforces.example.testRDD" \
    --jars \
        hdfs:///user/root/YELP/lib/geospark-sql_2.11-1.2.0.jar,hdfs:///user/root/YELP/lib/geospark-viz_2.11-1.2.0.jar,hdfs:///user/root/YELP/lib/geospark_2.11-1.2.0.jar \
    hdfs:///user/root/YELP/target/scala-2.11/yelp_2.11-0.1.4.jar \
