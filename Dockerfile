# Etap 1: Budowanie projektu
FROM maven:3-openjdk-17 AS build

LABEL authors="marko"

# Ustaw katalog roboczy
WORKDIR /app

# Skopiuj pliki projektu i zbuduj aplikację
COPY . .
RUN mvn package

# Etap 2: Uruchomienie aplikacji
FROM openjdk:17-jdk-slim
WORKDIR /app

# Skopiuj skompilowany plik JAR z etapu budowania
COPY --from=build /app/target/advanced-todo-app-1.0-SNAPSHOT.jar app.jar

# Eksponuj port 8080
EXPOSE 8080

# Uruchom aplikację
CMD ["java", "-jar", "app.jar", "--server.port=8080"]
