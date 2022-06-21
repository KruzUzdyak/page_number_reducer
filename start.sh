#!/bin/bash

git pull

mvn clean
mvn package

docker-compose stop

export APP_URL=$1

docker-compose up --build -d