# Stage 1
FROM maven:3.9.6-eclipse-temurin-11-alpine as stage1
WORKDIR /opt/build
COPY pom.xml .
RUN  mvn dependency:go-offline
COPY ./src ./src
RUN mvn clean package -Dmaven.test.skip=true

# Stage 2
FROM adoptopenjdk/openjdk11:alpine-jre as stage2
ARG JAR_FILE=target/page-number-reducer-*.jar
WORKDIR /opt/app
COPY --from=stage1 /opt/build/target/page-number-reducer-*.jar /opt/app/app.jar
ENV APP_URL=APP_URL
EXPOSE 8080
ENTRYPOINT ["java", "-Dapp.url=${APP_URL}", "-jar", "app.jar"]
