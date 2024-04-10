# First stage: build the jar file
FROM maven:3.9.6 as builder
WORKDIR /Url-Shortener
COPY pom.xml .
COPY src ./src
RUN mvn clean package

# Second stage: build the application using the jar file from the first stage
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=builder /Url-Shortener/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
