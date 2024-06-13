FROM maven:3.3.0-openjdk-21-slim AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} ./app.jar

EXPOSE 8081

CMD ["java", "-jar", "/app/app.jar"]
