# Use an official OpenJDK image with JDK included
FROM openjdk:11-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the source code (Java files) and resources into the container
COPY ./src/main/java/com/sdaia/assignment/Dev/Assignment/MonitorApp /app

# Compile the Java code and create the JAR file
RUN javac -d bin src/main/java/com/sdaia/assignment/Dev/Assignment/MonitorApp/*.java
RUN jar cvfe MonitorApp.jar com.sdaia.assignment.Dev.Assignment.MonitorApp.MonitorAppApplication -C bin .

# Expose the port your app runs on
EXPOSE 8082

# Run the application
CMD ["java", "-jar", "MonitorApp.jar"]
