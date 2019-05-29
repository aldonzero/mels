#!/usr/bin/env bash

dos2unix docker/java/start.sh

mvn clean;
mvn package;

cp target/mels.jar  docker/java/app.jar
