# Base image
FROM openjdk:11-jre-slim

# Set the working directory
WORKDIR /app

# Copy the jar file
COPY target/shop.jar .

# Expose the port that the app will listen on
EXPOSE 8080

# Start the app
CMD ["java", "-jar", "shop.jar"]
