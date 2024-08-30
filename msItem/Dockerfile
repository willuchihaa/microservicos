FROM openjdk:18-jdk-slim
WORKDIR /app

COPY /target/msItem-0.0.1-SNAPSHOT.jar ms-item.jar
EXPOSE 8082
ENTRYPOINT java -jar ms-item.jar
