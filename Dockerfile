FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
EXPOSE 443
COPY ${JAR_FILE} app.jar
COPY src/main/resources/sample.db src/main/resources/sample.db
COPY src/main/resources/keystore/javadevjournal.p12 src/main/resources/keystore/javadevjournal.p12
ENTRYPOINT ["java","-jar","/app.jar"]