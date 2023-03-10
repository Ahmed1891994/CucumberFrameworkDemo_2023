#!/usr/bin/env bash
# Environment Variables
# HUB_HOST
# MODULE

echo "Checking if hub is ready - $HUBHOST"
while [ "$( curl -s http://$HUBHOST:4444/wd/hub/status | jq -r .value.ready )" != "true" ]
do
	sleep 1
done

# start the java command
java xf framework_jar-tests.jar
mkdir -p src/test/resources
cp framework_jar-tests.jar src/test/resources/framework_jar-tests.jar
java -cp framework_jar.jar:src/test/resources/framework_jar-tests.jar:libs/* -DHUBHOST=$HUBHOST -Denv=prod org.testng.TestNG $MODULE
    
