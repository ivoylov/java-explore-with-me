FROM amazoncorretto:11-alpine-jdk
LABEL authors="gleb"
COPY server/target/server-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]