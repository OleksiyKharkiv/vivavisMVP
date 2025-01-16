# Use an official Java runtime as a parent image
FROM openjdk:21

# Set the working directory in the container
WORKDIR /app

# Copy the compiled .jar file from the local machine to the container
COPY build/libs/demo1-0.0.1-SNAPSHOT.jar /app/vivavis-app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "vivavis-app.jar"]

# Expose the port the app will run on
EXPOSE 8080
