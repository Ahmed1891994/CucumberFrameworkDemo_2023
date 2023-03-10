#!/usr/bin/env bash
# Environment Variables
# HUB_HOST
# MODULE

echo "Checking if hub is ready - $HUBHOST"
while [ "$( curl -s http://$HUBHOST:4444/wd/hub/status | jq -r .value.ready )" != "true" ]
do
	sleep 1
done
sleep 10000000
# start the java command
java xf framework_jar-tests.jar
cp features src/test/resources/features
java -cp framework_jar.jar:framework_jar-tests.jar:libs/* -DHUBHOST=$HUBHOST -Denv=prod org.testng.TestNG $MODULE
    
