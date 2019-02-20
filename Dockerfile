#################################
#
#   Builder - Creates the build
#
#################################

FROM maven:3.6.0-jdk-8-alpine as builder
COPY . .
RUN ["mvn", "package"]
RUN ["ls", "target"]

#################################
#
#   Server - Hosts build
#
#################################

FROM openjdk:8-jdk-alpine

EXPOSE 8090
ARG JAR_FILE=target/OSFAMicroService-0.0.1-SNAPSHOT.jar

COPY --from=builder ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
