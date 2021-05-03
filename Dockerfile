FROM maven:3.6.3-openjdk-14-slim AS build
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY . .
RUN mvn package
ARG DEPENDENCY=/build/target/dependency
RUN mkdir -p ${DEPENDENCY} && (cd ${DEPENDENCY}; jar -xf ../*.jar)


# Runnable image
FROM openjdk:14-alpine as runnable
VOLUME /tmp
VOLUME /logs
ARG DEPENDENCY=/build/target/dependency
RUN addgroup -S awesome && adduser -S awesome -G awesome
USER awesome

# Copy libraries & meta-info & classes
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
# Run application
ENTRYPOINT ["java","-cp","app:app/lib/*","com.jumia.javaexercise"]