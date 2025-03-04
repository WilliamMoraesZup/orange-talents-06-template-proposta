
FROM adoptopenjdk/openjdk11:alpine
ARG JAR_FILE=target/proposta-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/app.jar"]
EXPOSE 8181