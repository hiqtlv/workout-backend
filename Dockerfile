# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine
# copy WAR into image
COPY target/workout-rest-services-0.0.1-SNAPSHOT.jar /app.jar
# run application with this command line 
CMD ["/usr/bin/java", "-jar", "/app.jar"]