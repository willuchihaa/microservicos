FROM openjdk:18-jdk-slim
WORKDIR /app

COPY /target/msUsuario-0.0.1-SNAPSHOT.jar ms-usuario.jar
EXPOSE 8084
ENTRYPOINT java -jar ms-usuario.jar
