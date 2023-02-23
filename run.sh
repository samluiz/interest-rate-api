mvn package -DskipTests
docker-compose build
docker-compose up --force-recreate