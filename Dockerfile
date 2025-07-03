# Start from an OpenJDK 17 Alpine base image (lightweight)
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside the container
WORKDIR /app

# Copy the Spring Boot jar file into the container
COPY target/*.jar app.jar

# Expose port 8080 (match your Spring Boot server.port)
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
