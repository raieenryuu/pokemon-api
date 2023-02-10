FROM openjdk:19-jdk-alpine
COPY target/pokemon-0.0.1-SNAPSHOT.jar pokemon-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/pokemon-0.0.1-SNAPSHOT.jar"]


