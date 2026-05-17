# Use the OpenJDK 8 Alpine image as the base
FROM openjdk:8-jdk-alpine

# Create a user and group 'ptiwari' for running the application
RUN addgroup -S ptiwari && adduser -S ptiwari -G ptiwari

# Create necessary directories and files
RUN mkdir -p /opt/app/logs /app/lib /app/META-INF
RUN touch /opt/app/logs/spring-boot-logger.log
RUN chmod -R 777 /opt/app

# Switch to the 'ptiwari' user for security purposes
USER ptiwari:ptiwari

# Define the 'DEPENDENCY' argument for copying application dependencies
ARG DEPENDENCY=build/dependency

# Copy application dependencies and resources
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app

# Add the application JAR file
ADD build/libs/surshri-latest.jar /app/com.surshree.app.SurShreeApplication.jar

# Set the entry point for running the application
ENTRYPOINT ["java", "-cp", "app:app/lib/*", "com.surshree.app.SurShreeApplication"]
