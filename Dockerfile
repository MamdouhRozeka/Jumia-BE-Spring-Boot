FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
EXPOSE 80
COPY ${JAR_FILE} app.jar
COPY src/main/resources/sample.db src/main/resources/sample.db
ENTRYPOINT ["java","-jar","/app.jar"]