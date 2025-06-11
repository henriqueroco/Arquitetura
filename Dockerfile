
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY target/sistema.jar sistema.jar
ENTRYPOINT ["java", "-jar", "sistema.jar"]
