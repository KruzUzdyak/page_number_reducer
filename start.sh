#!/bin/bash

docker-compose stop

git pull

docker build --tag=page-number-reducer .

export APP_URL=$1

docker-compose up -d
