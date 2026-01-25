# Etapa 1: Construcción (Build) usando Java 21 (que es lo que pide tu proyecto)
FROM maven:3.9.6-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución (Runtime)
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
# El nombre del JAR debe coincidir exactamente con el que genera Maven
COPY --from=build /target/BackendProyectoBW-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Xmx256m", "-jar", "app.jar"]
