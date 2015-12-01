# Random service sample Java App

This webapp provides a service to reverse a message and provide a random number. The message needs to be send by HTTP POST to the service endpoint /api. The request body needs to contain the message in JSON format
{message: "This is a message!"}

The output will reverse the message string:
{"message":"!egassem a si sihT","rand":0.40311003}

Requirements:

Java 7
Maven 3
Reverse Service: the Random service relies on another service (https://github.com/sepsyk/ReverseServiceJavaSampleApp), which is expected to run by default on localhost, port 8081. The reverse service API endpoint can be changed in src/main/webapp/WEB-INF/reverseservice.properties


Steps to run the service:
1. Follow the steps on https://github.com/sepsyk/ReverseServiceJavaSampleApp to install and run Reverse service.
2. Install prerequsites (Java, Maven)
3. Clone the sources from Github
4. Build the sources: mvn clean install
5. Run the service in an embedded Jetty container: mvn jetty:run
6. Post requests with the given JSON format to http://hostname:8080/api
