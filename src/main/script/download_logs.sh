#!/bin/bash

docker ps | tail -n +2 | while read container image _; do
    echo "Downloading logs from $container[$image]"
    ip=`docker inspect --format '{{ .NetworkSettings.IPAddress }}' $container`
    mkdir -p target/logs
    docker logs $container > target/logs/$ip.${image##*\/}.log.txt
done
