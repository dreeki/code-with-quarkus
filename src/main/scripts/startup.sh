#!/bin/bash

#docker logout
#docker login

echo "enter your docker repo with tag"

read repoName
cd ../../../

chmod +x mvnw
./mvnw package

docker build -f src/main/docker/Dockerfile.jvm -t $repoName .
docker run -i --rm -p 8080:8080 $repoName
