FROM openjdk:17-alpine
WORKDIR /app
ADD docker_postgres_init.sql /docker-entrypoint-initdb.d
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw -Dmaven.test.skip=true dependency:go-offline
COPY src ./src
CMD ["./mvnw", "spring-boot:run", "-Dspring-boot.run.profiles=doc"]