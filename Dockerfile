FROM maven:3.6.3-jdk-8
COPY ./ ./
RUN mvn clean package
CMD ["java", "-jar", "target/Jumia-BE-Spring-Boot-0.0.1-SNAPSHOT.jar"]