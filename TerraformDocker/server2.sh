#!/usr/bin/bash

whoami

mkdir -p /home/debian
cd /home/debian
echo in directory $PWD

sudo apt-get update
sudo apt-get upgrade -y
sudo apt update
sudo apt upgrade -y


echo "--------Installing curl--------"
sudo apt-get install curl -y

echo "--------Installing wget--------"
sudo apt-get install wget -y

echo "--------Installing Unzip--------"
sudo apt-get install unzip -y

echo "-----------------Installing Docker-----------------"
sudo apt update
sudo apt install apt-transport-https ca-certificates curl gnupg2 software-properties-common -y
curl -fsSL https://download.docker.com/linux/debian/gpg | sudo apt-key add -
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/debian $(lsb_release -cs) stable"
sudo apt update
apt-cache policy docker-ce
sudo apt install docker-ce -y
docker --version

echo "-----------------Adding Docker Permissions-----------------"
sudo chmod 666 /var/run/docker.sock
sudo groupadd docker
sudo usermod -aG docker $USER
newgrp docker

sudo systemctl restart docker

docker network create --driver bridge --subnet 172.28.0.0/16 custom-network


echo "-----------------Pulling MariaDB Docker Image-----------------"
docker pull mariadb:10.11
echo "-----------------Running MariaDB Docker Image-----------------"
docker run --name mariadb-server -e MYSQL_ROOT_PASSWORD=comsc -e MYSQL_PASSWORD=comsc --network custom-network -p 3306:3306 -d --network custom-network mariadb:10.11 


echo "-----------------Pulling Docker Image from Dockerhub-----------------"
sudo docker pull jp0123/smarttownsbuild
echo "-----------------Running MariaDB Docker Image-----------------"
sudo docker run --name stownsapp -e SERVER_PORT=8081 -p 8081:8081 -d --network custom-network jp0123/smarttownsbuild

docker images
docker network ls
docker ps -a