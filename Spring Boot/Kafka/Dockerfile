# syntax=docker/dockerfile:1.4
FROM maven:3.8.7-eclipse-temurin-17 AS builder
WORKDIR /app

# 1) copy pom.xml and download dependencies
COPY pom.xml .
RUN --mount=type=cache,target=/root/.m2 \
    mvn dependency:go-offline -B

# 2) copy the source code and build the application
COPY src ./src
RUN --mount=type=cache,target=/root/.m2 \
    mvn clean package -DskipTests -B

# ────────────────────────────────────────────────────────────────────────────
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# 3) copy the built jar from the builder stage
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/app.jar"]
