FROM amazoncorretto:21.0.5-alpine3.20

WORKDIR /app
COPY target/service-shuffle-*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
