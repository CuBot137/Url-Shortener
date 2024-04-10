# First stage: build the jar file
FROM openjdk:17-jdk-alpine as builder
WORKDIR /app
COPY .mvn/ .mvn

RUN chmod +x ./mvnw

RUN apt-get update && apt-get install -y dos2unix
RUN dos2unix ./mvnw

RUN ./mvnw dependency:resolve


COPY src ./src
CMD ["*./mvwn*", "*spring-boot:run*"]

# Second stage: build the application using the jar file from the first stage
#FROM openjdk:17-jdk-alpine
#WORKDIR /app
#EXPOSE 8080
#COPY --from=builder /app/target/*.jar app.jar
#ENTRYPOINT ["java", "-jar", "app.jar"]
