# Stage 1: Build the application
FROM maven:3.9.4-eclipse-temurin-17 AS build

# Set the working directory
COPY . .


# Package the application (skip tests for faster build, adjust as necessary)
RUN mvn clean package -DskipTests


FROM eclipse-temurin:17-alpine
# Copy only the built JAR file from the Maven build stage
COPY --from=build /target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Set the entry point to run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]