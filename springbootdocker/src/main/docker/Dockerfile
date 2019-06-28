FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD springbootdocker.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]