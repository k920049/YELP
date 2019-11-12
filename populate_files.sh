#!/usr/bin/env bash
docker cp ../YELP/ sandbox-hdp:/home/root
docker exec -t sandbox-hdp hdfs dfs -rm -R -skipTrash /user/root/YELP
docker exec -t sandbox-hdp hdfs dfs -put /home/root/YELP/ /user/root