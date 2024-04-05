FROM maven:3.6.3-jdk-13 as builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn package -DskipTests


FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/Url-Shortener-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]


#COPY --from=builder target/Url-Shortener-*.jar /app.jar