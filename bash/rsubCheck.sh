#!/bin/bash

cd /app/batch/RDemon
PID=`ps -ef | grep RNTSub.jar | grep java | awk '{print $2}'`
echo "Start PID : $PID"
echo "kill -9 $PID"
if [ -n "$PID" ]
then
   echo "======== RNTSub.jar is running!. ========"
else
   echo "======== RNTSub.jar is starting!. ========"
   java -jar /app/batch/RDemon/RNTSub.jar &
fi
