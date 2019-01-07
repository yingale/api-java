#!/bin/bash
export JAVA_HOME=/usr/lib/jvm/java-8-oracle
DATE=$(date +%F)
LOGFILE=/tmp/productmatrix_api.log.$DATE
java -jar /home/yogesh/eclipse-workspace/productmatrix_api/target/productmatrix-0.0.1-SNAPSHOT.jar --spring.config.location=file:/home/yogesh/eclipse-workspace/productmatrix_api/src/main/resources/application.properties >>$LOGFILE 2>&1

