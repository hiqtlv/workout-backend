# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine
# copy WAR into image
COPY /root/.m2/repository/se/hiq/workout-rest-services/0.0.1-SNAPSHOT/workout-rest-services-0.0.1-SNAPSHOT.jar /app.jar
# run application with this command line 
CMD ["/usr/bin/java", "-jar", "/app.jar"]
