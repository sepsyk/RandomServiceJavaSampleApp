#Dockerfile to install and run RandomService
FROM ubuntu:14.04

MAINTAINER Karoly Sepsy

WORKDIR /root

RUN apt-get update
#install java 7
RUN apt-get install openjdk-7-jdk -y
#install mvn3
RUN apt-get install maven -y
#install wget for downloads
RUN apt-get install wget -y
#download Random service
RUN wget https://github.com/sepsyk/RandomServiceJavaSampleApp/archive/master.zip
#unzip and clean up
RUN unzip -x master.zip 
RUN rm master.zip
RUN cd RandomServiceJavaSampleApp-master/
#build service and run unit tests 
RUN cd /root/RandomServiceJavaSampleApp-master;mvn clean install
#run service in container
CMD cd /root/RandomServiceJavaSampleApp-master;mvn jetty:run


