# Random service sample Java App

This webapp provides a service to reverse a message and provide a random number. The message needs to be send by HTTP POST to the service endpoint /api. The request body needs to contain the message in JSON format
{message: "This is a message!"}

The output will reverse the message string:
{"message":"!egassem a si sihT","rand":0.40311003}

Requirements:

Java 7
Maven 3

Reverse Service: the Random service relies on another service (https://github.com/sepsyk/ReverseServiceJavaSampleApp), which is expected to run in docker by default with service name 'reverse', linked to this apps container, listening on port 8081. The reverse service API endpoint can be changed in src/main/webapp/WEB-INF/reverseservice.properties


Steps to run the service:

1. Follow the steps on https://github.com/sepsyk/ReverseServiceJavaSampleApp to install and run Reverse service.

2. Install prerequsites (Java, Maven)

3. Clone the sources from Github

4. Build the sources: mvn clean install

5. Run the service in an embedded Jetty container: mvn jetty:run

6. Post requests with the given JSON format to http://hostname:8080/api

Alternatively, use the Dockerfile placed in the root to run the service in Docker.

Continuous Integration tests are done automatically by Travis CI, the Github integrated CI tool. The test procedure is described in .travis.yml file. Travis launches docker containers to test the maven build of the service, and runs JUnit tests. After that, integration tests are validating if the service is up and operating, by running simple curl based smoke tests against the container service endpoint.
