# Use a base image with Java and Maven installed
FROM maven:3.8.4-openjdk-11-slim AS build

# Set the working directory in the Docker image
WORKDIR /app

# Copy the Maven project files into the Docker image
COPY pom.xml .
COPY src ./src

# Build the Selenium project
RUN mvn clean package

# Use a smaller base image for the final Docker image
FROM openjdk:11-jre-slim

# Set working directory in the Docker image
WORKDIR /app

# Copy the compiled Selenium JAR file into the Docker image
COPY --from=build /app/target/SeleniumFrameworkDesign-0.0.1-SNAPSHOT.jar .
# Copy the JAR file into the Docker image
#COPY target/SeleniumFrameworkDesign-0.0.1-SNAPSHOT.jar /app/target/

# Specify the command to run your application
CMD ["java", "-jar", "SeleniumFrameworkDesign-0.0.1-SNAPSHOT.jar"]
