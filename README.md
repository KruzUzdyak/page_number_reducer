# PageNumberReducer Application

## Summary

Application can transform number sequences like ```4,3,2,1,7,8``` into ```1-4,7,8```. 
Numbers in sequence can go unsorted, duplicated, with spaces and must be separated by comma.
Numbers can't be zero, negative or starts from zero.

## Preparation Steps

+ Download and install JDK11+
+ Download and install Maven

## Configuration

+ App can be configured via application.yaml file in resources package (now it has only configuration for OpenAPI 3.0):
  - app.description - for OpenAPI description
  - app.version - for OpenAPI version of current API
  - app.server.url - for OpenAPI url of application
  - app.url - environment variable, overrides previous one
  - app.server.stage - define stage of the app server

## Build

+ Run ```mvn clean install``` in CLI

## Deployment

+ run ```java -jar page-number-reducer-***.jar``` in CLI
+ check [http://localhost:8080/swagger-ui/index.html] for OpenAPI-UI