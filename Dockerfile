# Use an official OpenJDK base image
FROM openjdk:17-jdk-slim

# Set a working directory inside the image
WORKDIR /app

# Copy the Maven/Gradle built JAR file into the container
# Assuming your JAR file will be named as `stocktracker-backend.jar`
# Update this if the JAR file name is different
COPY target/stocktracker-backend-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Set the entry point to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]