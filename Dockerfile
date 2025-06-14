# Используем официальный базовый образ Java 21
FROM eclipse-temurin:21-jdk

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем собранный jar-файл (уточни имя, если оно другое)
COPY target/*.jar app.jar

# Указываем порт, который будет прослушивать Spring Boot
EXPOSE 8080

# Команда запуска Spring Boot
ENTRYPOINT ["java", "-jar", "ap
