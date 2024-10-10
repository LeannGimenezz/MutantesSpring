# Primera etapa: construir el proyecto
FROM maven:3.8.5 AS build

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo pom.xml y las dependencias
COPY pom.xml .
COPY src ./src

# Compilar el proyecto y empaquetarlo
RUN mvn clean package -DskipTests

# Segunda etapa: crear la imagen final
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/MutantesSpringBoot-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto que utiliza tu aplicación Spring Boot
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
