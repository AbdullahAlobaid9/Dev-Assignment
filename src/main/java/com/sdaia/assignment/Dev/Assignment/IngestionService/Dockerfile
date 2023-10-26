# Use an official OpenJDK image with JDK included as build stage
FROM openjdk:11-jdk-slim as build

# Set the working directory inside the container
WORKDIR /app

# Copy the source code for IngestionService
COPY . .

# Compile the Java code and create the JAR file
RUN javac -d bin *.java

# Create the JAR file
RUN jar cvfe IngestionService.jar com.sdaia.assignment.Dev.Assignment.IngestionService.IngestionServiceApplication -C bin .

# Use a smaller image for runtime
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/IngestionService.jar .

# Expose the port your app runs on
EXPOSE 8081

# Run the application
CMD ["java", "-jar", "IngestionService.jar"]
