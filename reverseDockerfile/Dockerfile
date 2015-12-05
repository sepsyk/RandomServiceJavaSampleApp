#Dockerfile to install and run ReverseService
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
RUN git clone https://github.com/sepsyk/ReverseServiceJavaSampleApp.git
RUN cd ReverseServiceJavaSampleApp/
#build service and run unit tests 
RUN cd /root/ReverseServiceJavaSampleApp;mvn clean install
#run service in container
CMD cd /root/ReverseServiceJavaSampleApp;mvn jetty:run


