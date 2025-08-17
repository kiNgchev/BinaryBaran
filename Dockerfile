FROM openjdk:21-jdk-slim

WORKDIR /app

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
RUN chmod +x gradlew
RUN ./gradlew dependencies --no-daemon

COPY src src
RUN ./gradlew build -x test --no-daemon && \
    cp build/libs/*.jar app.jar && \
    rm -rf src gradle build.gradle settings.gradle gradlew

ENTRYPOINT ["java", "-jar", "app.jar"]