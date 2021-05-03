FROM maven:3.6.3-jdk-8
COPY ./ ./
RUN mvn clean package
CMD ["java", "-jar", "target/java-exercise-0.0.1-SNAPSHOT.jar"]