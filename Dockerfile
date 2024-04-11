# Get Java 17 image
FROM openjdk:17

# Copy the builded .jar file into docker
COPY /build/libs/* /studentcronjob

# Run the application
ENTRYPOINT ["java","-jar","/studentcronjob.jar"]

# Expose the port that your application will run on
EXPOSE 8081