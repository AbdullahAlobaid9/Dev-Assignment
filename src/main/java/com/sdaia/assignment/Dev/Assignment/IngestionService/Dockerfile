# Use an official Maven image as build stage
FROM maven:3.8.1-openjdk-17 as build

# Set the working directory inside the container
WORKDIR /app

# Copy the source code for WeatherDataGenerator
COPY . .

# Package the Spring Boot application into a JAR file
RUN mvn clean package

# Use a smaller image for runtime
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port your app runs on
EXPOSE 8082

# Run the application
CMD ["java", "-jar", "app.jar"]