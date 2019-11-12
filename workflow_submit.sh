#!/usr/bin/env bash
oozie job \
    -oozie http://sandbox-hdp.hortonworks.com:11000/oozie \
    -run -config ./job.properties

