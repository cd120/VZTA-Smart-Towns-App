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

echo "-----------------Creating Custom-Network Bridge-----------------"
docker network create --driver bridge --subnet 172.28.0.0/16 custom-network

echo "-----------------Pulling MariaDB Docker Image-----------------"
docker pull mariadb:10.11
echo "-----------------Running MariaDB Docker Image-----------------"
docker run --name mariadb-server -e MYSQL_DATABASE=trailsdb -e MYSQL_ROOT_PASSWORD=comsc -p 127.0.0.1:3306:3306 -d --network custom-network mariadb:10.11

echo "-----------------Pulling Docker Image from Dockerhub-----------------"
sudo docker pull jp0123/smarttownsbuild
echo "-----------------Running MariaDB Docker Image-----------------"
sudo docker run --name stownsapp1 -e SERVER_PORT=8081 -p 8081:8081 -d --network host jp0123/smarttownsbuild
sudo docker run --name stownsapp2 -e SERVER_PORT=8082 -p 8082:8082 -d --network host jp0123/smarttownsbuild
#sudo docker run --name stownsapp2 -e SERVER_PORT=8083 -p 8083:8083 -d --network host jp0123/smarttownsbuild

docker images
docker network ls
docker ps -a

echo "----------------Installing Nginx-----------------"
sudo apt install nginx -y

echo "----------------Nginx Configuration-----------------"
sudo cat /etc/nginx/nginx.conf > /home/debian/backup_nginx.txt
sudo rm /etc/nginx/nginx.conf

sudo sh -c 'cat <<EOF > /etc/nginx/nginx.conf
user www-data;
worker_processes auto;
pid /run/nginx.pid;

# Load dynamic modules.
include /etc/nginx/modules-enabled/*.conf;

events {
    worker_connections 768;
    multi_accept on;
    use epoll;
}

http {

upstream smarttownsbuild {
        ip_hash;
        server localhost:8081;
        server localhost:8082;
        #server localhost:8083;
 }
    # Basic Settings
    sendfile on;
    tcp_nopush on;
    tcp_nodelay on;
    keepalive_timeout 65;
    types_hash_max_size 2048;
    client_max_body_size 16m;

    include /etc/nginx/mime.types;
    default_type application/octet-stream;

    # SSL Settings
    ssl_protocols TLSv1.2 TLSv1.3;
    ssl_prefer_server_ciphers on;
    ssl_session_timeout 10m;

    # Logging Settings
    access_log /var/log/nginx/access.log;
    error_log /var/log/nginx/error.log;

    # Gzip Compression Settings
    gzip on;
    gzip_http_version 1.1;
    gzip_types text/plain text/css application/json application/javascript application/x-javascript text/xml application/xml application/xml+rss text/javascript;

    # allow the server to close connection on non responding client, this frees up memory
    reset_timedout_connection on;

    # Virtual Host Configs
    include /etc/nginx/conf.d/*.conf;
    include /etc/nginx/sites-enabled/*;

    #  Server
    server {
        listen 8080;

        location / {
            proxy_pass http://smarttownsbuild;
        }
    }
}
EOF'

sudo systemctl restart nginx
sudo nginx -t

#debugging
#curl -i http://localhost:8081/path-to-resource
#curl -i http://localhost:8082/path-to-resource
#
#sudo tail -f /var/log/nginx/access.log
#curl -I http://localhost:8081/
#curl -I http://localhost:8082/
#sudo netstat -tulnp | grep :8082
