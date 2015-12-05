#Dockerfile to install and run RandomService
FROM ubuntu:14.04

MAINTAINER Karoly Sepsy

WORKDIR /root

RUN apt-get update
#install java 7
RUN apt-get install openjdk-7-jdk -y
#install mvn3
RUN apt-get install maven -y
#install git
RUN sudo apt-get install git-all -y
#checkout Reverse service from Github
RUN git clone https://github.com/sepsyk/RandomServiceJavaSampleApp.git
RUN cd RandomServiceJavaSampleApp/
#build service and run unit tests 
RUN cd /root/RandomServiceJavaSampleApp;mvn clean install
#run service in container
CMD cd /root/RandomServiceJavaSampleApp;mvn jetty:run


