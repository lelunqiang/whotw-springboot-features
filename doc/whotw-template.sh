#!/usr/bin/env bash

echo '---------stop $1 container----------'
docker-compose stop $1
echo '---------rm $1 container----------'
docker-compose rm $1
echo '---------rmi $1 image----------'
docker-compose rmi $1
echo '---------rm none image----------'
docker-compose rmi `docker images |grep none |awk '{print $3}'`
echo '---------build $1 image----------'
docker-compose build $1
echo '---------running $1 ----------'
docker-compose up  $1