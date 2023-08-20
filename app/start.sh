#!/bin/sh
docker build -t mars-mission .

docker run -d -p 8080:8080 mars-mission
