# PageNumberReducer Application

## Summary

Application can transform unordered page number sequences like ```4,3,2,1,7,8``` into ordered intervals ```1-4,7,8```. 
Numbers in sequence can go unordered, duplicated, with spaces and must be separated by comma.
Numbers can't be zero, negative or starts from zero.

## Preparation Steps

+ Your only need docker installed

## Configuration

+ App can be configured via application.yaml file in resources package (now it has only configuration for OpenAPI 3.0):
  - app.description - for OpenAPI description
  - app.version - for OpenAPI version of current API
  - app.server.url - for OpenAPI url of application
  - app.server.stage - define stage of the app server

+ Environment variables on startup:
  - APP_URL - overrides ```app.server.url``` from application.yaml

## Build

+ Run ```mvn clean install``` in CLI
#### OR
+ Just wait for docker build after executing `start.sh`

## Deployment

+ run ```bash start.sh ${APP_URL}``` in CLI
+ check [link](http://localhost:9000/swagger-ui/index.html) for OpenAPI-UI
+ stop app by ```bash stop.sh``` in CLI
