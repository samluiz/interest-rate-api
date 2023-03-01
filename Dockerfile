FROM eclipse-temurin:11-jdk-jammy as base

WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN sed -i 's/\r$//' mvnw
COPY src ./src

FROM base as test
RUN ./mvnw test

FROM base as build
RUN ./mvnw package -Dskip-tests

FROM eclipse-temurin:11-jdk-jammy as production

EXPOSE 8080
COPY --from=build app/target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]