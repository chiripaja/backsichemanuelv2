# Usar una imagen base de OpenJDK 17
FROM openjdk:17-jre-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR a la imagen
COPY apirest-v1.jar apirest-v1.jar

# Exponer el puerto en el que la aplicación escucha (ajusta según sea necesario)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
