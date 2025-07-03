# Stage 1: Build the jar
FROM maven:3.9.1-eclipse-temurin-21 AS builder
# Set working directory inside the container
WORKDIR /app

COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the jar
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

# Expose port 8080 (match your Spring Boot server.port)
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java","-jar","app.jar"]

