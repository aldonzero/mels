#!/usr/bin/env bash
JAVA_IP=192.168.99.100

sh build.sh
docker-compose build
docker-compose up

echo "============ The program is running, please wait. "
sleep 45;
