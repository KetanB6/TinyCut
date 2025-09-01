#use official OpenJDK image
FROM openjdk:21-jdk-slim

#Set the working directory
WORKDIR /app

#Copy the JAR file from target
COPY urlshortner-0.0.1-SNAPSHOT.jar /app/urlshortner-0.0.1-SNAPSHOT.jar


#Expose port
EXPOSE 8080

#Run the application

ENTRYPOINT ["java", "-jar", "urlshortner-0.0.1-SNAPSHOT.jar"]


