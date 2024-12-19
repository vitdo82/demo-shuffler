# Shuffler

This project consists of building an end-to-end system involving two microservices. One microservice processes the
request, and the other logs the request.

## Build & Run Project

Build project:

```shell
./mvnw clean install
```

Run projects in Docker Compose:

```shell
./mvnw clean install && docker-compose up --build --force-recreate
```

Build and run projects in Docker Compose:

```shell
./mvnw clean install && docker-compose up --build --force-recreate
```

## Test

After starting Docker Compose, test the API by executing the following curl command:

```shell
curl -X POST -H 'Content-Type: application/json' -d '10' http://localhost:8085/api/v1/generate
```
