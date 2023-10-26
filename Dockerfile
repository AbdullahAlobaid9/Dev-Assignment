# Stage 1: Build Weather Data Generator
FROM maven:3.8.4-openjdk-11 AS builder1
WORKDIR /app
COPY ./src/main/java/com/sdaia/assignment/Dev.Assignment/WeatherDataGenerator/pom.xml ./src/main/java/com.sdaia.assignment.Dev.Assignment/WeatherDataGenerator/
RUN mvn -B dependency:resolve
COPY ./src/main/java/com/sdaia/assignment/Dev.Assignment/WeatherDataGenerator/ ./src/main/java/com.sdaia.assignment.Dev.Assignment/WeatherDataGenerator/
RUN mvn -B package

# Stage 2: Build Ingestion Service
FROM maven:3.8.4-openjdk-11 AS builder2
WORKDIR /app
COPY ./src/main/java/com/sdaia/assignment/Dev.Assignment/IngestionService/pom.xml ./src/main/java/com.sdaia.assignment.Dev.Assignment/IngestionService/
RUN mvn -B dependency:resolve
COPY ./src/main/java/com.sdaia/assignment/Dev.Assignment/IngestionService/ ./src/main/java/com.sdaia.assignment.Dev.Assignment/IngestionService/
RUN mvn -B package

# Stage 3: Build Monitor App
FROM maven:3.8.4-openjdk-11 AS builder3
WORKDIR /app
COPY ./src/main/java/com/sdaia/assignment/Dev.Assignment/MonitorApp/pom.xml ./src/main/java/com.sdaia.assignment.Dev.Assignment/MonitorApp/
RUN mvn -B dependency:resolve
COPY ./src/main/java/com.sdaia/assignment/Dev.Assignment/MonitorApp/ ./src/main/java/com.sdaia.assignment.Dev.Assignment/MonitorApp/
RUN mvn -B package

# Stage 4: Create the final image with all applications
FROM openjdk:11-jre-slim
WORKDIR /app

# Copy application artifacts from builder stages
COPY --from=builder1 /app/target/WeatherDataGenerator-*.jar WeatherDataGenerator.jar
COPY --from=builder2 /app/target/IngestionService-*.jar IngestionService.jar
COPY --from=builder3 /app/target/MonitorApp-*.jar MonitorApp.jar

# Expose ports
EXPOSE 8080 8081 8082

# Command to run all applications
CMD ["java", "-jar", "WeatherDataGenerator.jar"]
