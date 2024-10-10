FROM maven:3.8.5-openjdk-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

# Compilar el proyecto y empaquetarlo
RUN mvn clean package -DskipTests

# Segunda etapa para crear la imagen final
FROM openjdk:17-alpine
WORKDIR /app

# Exponer el puerto utilizado por la aplicación Spring Boot
EXPOSE 9000

# Copiar el archivo JAR desde la etapa de construcción
COPY --from=build /app/target/MutantesSpringBoot-0.0.1-SNAPSHOT.jar ./app.jar

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
