# our base build image
FROM maven:3.8.7-eclipse-temurin-11-alpine as maven
WORKDIR /app
# copy the Project Object Model file
COPY ./pom.xml ./pom.xml
# fetch all dependencies
RUN mvn dependency:go-offline -B
# copy your other files
COPY ./src ./src
# build for release
# NOTE: my-project-* should be replaced with the proper prefix
RUN mvn package -DskipTests && cp target/interestrateapi-*.jar app.jar
# smaller, final base image
FROM eclipse-temurin:11-alpine
# set deployment directory
WORKDIR /app
# copy over the built artifact from the maven image
COPY --from=maven /app/app.jar ./app.jar
# set the startup command to run the binary
CMD ["java", "-jar", "/app/app.jar"]