FROM openjdk:17-jdk-alpine
MAINTAINER apis-it.hr
COPY target/demo-0.0.1-SNAPSHOT.jar demo.jar
RUN mkdir -p /dat/
COPY dat/seats.txt dat/seats.txt
EXPOSE 8888
ENTRYPOINT [ "java","-jar","/demo.jar" ]