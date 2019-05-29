#!/usr/bin/env bash

echo "-------------------Prepare mysql,please wait---------------------";
sleep 20;
echo "----------The mysql is ready,running the Java program--------------";
java -jar app.jar;
echo "----------End of the program run---------------------------------";
