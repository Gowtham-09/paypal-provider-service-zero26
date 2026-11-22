# Base image: Amazon Linux 2023
FROM amazonlinux:2023

# Set /app as the working diectory inside the container
WORKDIR /app

# Update packages, install java 21, and clean package cache
RUN dnf update -y \
	&& dnf install -y java-21-amazon-corretto \
	&& dnf clean all \
	&& rm -rf /var/cache/dnf
	
# Copy the Spring Boot JAR from host into /app
COPY target/paypal-provider-service.jar .

# Document that the application listens on port 8082
EXPOSE 8083

# Start the Spring Boot application when the container starts
ENTRYPOINT ["java", "-jar", "paypal-provider-service.jar"]

