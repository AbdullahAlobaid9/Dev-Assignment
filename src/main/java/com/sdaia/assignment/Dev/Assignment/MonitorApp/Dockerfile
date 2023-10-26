# Use an official OpenJDK image with JDK included as build stage
FROM openjdk:11-jdk-slim as build

# Set the working directory inside the container
WORKDIR /app

# Copy the source code for MonitorApp
COPY . .

# Compile the Java code and create the JAR file
RUN javac -d bin *.java

# Create the JAR file
RUN jar cvfe MonitorApp.jar com.sdaia.assignment.Dev.Assignment.MonitorApp.MonitorAppApplication -C bin .

# Use a smaller image for runtime
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/MonitorApp.jar .

# Expose the port your app runs on
EXPOSE 8082

# Run the application
CMD ["java", "-jar", "MonitorApp.jar"]
