#!/bin/bash

container=$1

ip=`docker exec -ti $container ip -4 addr | grep "global eth0" | grep -Po "\d+\\.\d+\\.\d+\\.\d+"`

docker logs $container > $ip.$container.log.txt
