# Use Eclipse Temurin 17 as base image (official OpenJDK distribution)
FROM eclipse-temurin:17-jdk-jammy

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy source code
COPY src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose port (Render will provide PORT environment variable)
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/Personal-Chat-Backend-0.0.1-SNAPSHOT.jar"]
