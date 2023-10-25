# Use an official OpenJDK image with JDK included
FROM openjdk:11-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the source code (Java files) and resources into the container
COPY . .

# Compile the Java code and create the JAR file
RUN javac -d bin src/main/java/com/sdaia/assignment/Dev/Assignment/IngestionService/*.java
RUN jar cvfe IngestionService.jar com.sdaia.assignment.Dev.Assignment.IngestionService.IngestionServiceApplication -C bin .

# Expose the port your app runs on
EXPOSE 8081

# Run the application
CMD ["java", "-jar", "IngestionService.jar"]
