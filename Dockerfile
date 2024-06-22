FROM maven:3.9.7-eclipse-temurin-21-alpine AS builder

WORKDIR /app

COPY . /app

RUN --mount=type=cache,target=/root/.m2 mvn -f /app/pom.xml clean package

FROM eclipse-temurin:21-alpine
 
COPY --from=builder /app/target/streaming-videos-*.jar /streaming-videos.jar
 
CMD ["java", "-Xmx500m", "-jar", "/streaming-videos.jar"]
