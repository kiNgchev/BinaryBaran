FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /app

COPY gradlew .
COPY gradle gradle
COPY buildSrc buildSrc
COPY baran-shared baran-shared
COPY baran-models baran-models
COPY baran-worker baran-worker
COPY settings.gradle.kts .

RUN chmod +x gradlew
RUN ./gradlew :baran-worker:build -x test --no-daemon --parallel

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

RUN addgroup -g 1001 -S appgroup
RUN adduser -u 1001 -S appuser -G appgroup

COPY --from=builder /app/baran-worker/build/libs/*.jar app.jar

USER appuser

ENTRYPOINT ["java", "-jar", "app.jar"]