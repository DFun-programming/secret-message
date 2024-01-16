# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY target/secret-message-0.0.1-SNAPSHOT.jar /app/app.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Define environment variable for MongoDB connection (adjust as needed)
ENV MONGODB_URI=mongodb+srv://d-programming:Debmallya182001@genzapp.cmnudmw.mongodb.net/Genzapp

# Run application when the container launches
CMD ["java", "-jar", "app.jar"]