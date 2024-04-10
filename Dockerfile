# First stage: build the jar file
FROM openjdk:17-jdk-alpine as builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
COPY .mvn/ .mvn
RUN ./mvn clean install

# Second stage: build the application using the jar file from the first stage
FROM openjdk:17-jdk-alpine
WORKDIR /app
EXPOSE 8080
COPY --from=builder /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
