FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/page-number-reducer-*.jar
WORKDIR /opt/app
ENV APP_URL=APP_URL
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dapp.url=${APP_URL}", "-jar", "app.jar"]