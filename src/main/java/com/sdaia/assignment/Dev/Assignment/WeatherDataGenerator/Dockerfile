# Use an official Maven image as build stage
FROM maven:3.8.1-openjdk-11 as build

# Set the working directory inside the container (not necessary for Maven build)
WORKDIR /app

# Copy the source code for WeatherDataGenerator to the /app directory
COPY . /app

# Package the Spring Boot application into a JAR file
RUN mvn -f /app/pom.xml clean package

# Use a smaller image for runtime
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/WeatherDataGenerator.jar .

# Expose the port your app runs on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "WeatherDataGenerator.jar"]
