# Usamos Java 17 que es la versión estable para Render
FROM eclipse-temurin:17-jre-alpine

# Directorio donde vivirá la app en el servidor
WORKDIR /app

# COPIAMOS el archivo .jar que generaste con el Clean and Build
# La ruta es target/ seguido del nombre exacto de tu archivo
COPY target/BackendProyectoBW-0.0.1-SNAPSHOT.jar app.jar

# El puerto que configuraste en application.properties
EXPOSE 8080

# Comando para iniciar la aplicación con memoria optimizada
ENTRYPOINT ["java", "-Xmx256m", "-jar", "app.jar"]
