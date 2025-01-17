# Usar una imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Crear el directorio donde estará la app
WORKDIR /app

# Copiar el archivo JAR de la aplicación al contenedor
COPY target/usuario-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto en el que la aplicación va a correr
EXPOSE 8002

# Comando para ejecutar la aplicación Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
