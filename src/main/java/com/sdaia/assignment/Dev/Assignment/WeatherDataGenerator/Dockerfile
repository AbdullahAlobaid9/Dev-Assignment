# Use an official OpenJDK image with JDK included
FROM openjdk:11-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the source code (Java files) and resources into the container
COPY . .

# Compile the Java code and create the JAR file
RUN javac -d bin src/main/java/com/sdaia/assignment/Dev/Assignment/WeatherDataGenerator/*.java
RUN jar cvfe WeatherDataGenerator.jar com.sdaia.assignment.Dev.Assignment.WeatherDataGenerator.WeatherDataGeneratorApplication -C bin .

# Expose the port your app runs on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "WeatherDataGenerator.jar"]
