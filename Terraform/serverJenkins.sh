#!/usr/bin/bash

whoami

mkdir -p /home/debian
cd /home/debian
echo logged in as $USER.
echo in directory $PWD

cd /home/debian
echo in directory $PWD

echo "--------Installing wget--------"
sudo apt install wget -y
echo "--------Installing curl--------"
sudo apt install curl -y
echo "--------Installing Unzip--------"
sudo apt install unzip -y


echo "--------Installing MariaDB 10.11.2--------"
curl -LsS https://r.mariadb.com/downloads/mariadb_repo_setup | sudo bash -s -- --mariadb-server-version="mariadb-10.11.2"
sudo apt update
sudo apt install mariadb-server -y
sudo systemctl start mariadb
sudo systemctl status mariadb
sudo systemctl enable mariadb

#changing root privileges of plugin 'unix_socket' to 'mysql_native_password'
echo "--------Changing Mysql Root Access Privileges--------"
sudo mysql -u root -e "UPDATE mysql.user SET plugin='mysql_native_password' WHERE User='root'";
sudo mysql -u root -e "USE mysql; UPDATE user SET password=PASSWORD('comsc') WHERE User='root' AND Host = 'localhost'; FLUSH PRIVILEGES;"
sudo mysql -u root -e "GRANT ALL PRIVILEGES on *.* TO root@localhost IDENTIFIED BY 'comsc' WITH GRANT OPTION;"



# echo "upgrading sudo..."
# sudo apt-get install sudo -y
# sudo apt install ca-certificates 
# sudo apt install gnupg2 -y
# echo whoami



# echo "Moving to root account..."
# cd root

# sudo touch /var/lib/jenkins/.ssh/known_hosts
# sudo ssh-keyscan git.cardiff.ac.uk >> /var/lib/jenkins/.ssh/known_hosts
# sudo chmod 644 /var/lib/jenkins/.ssh/known_hosts

cat << `EOF` >> gitlab_project_keypair2.key
-----BEGIN OPENSSH PRIVATE KEY-----
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
-----END OPENSSH PRIVATE KEY-----
`EOF`

#Restricts access rights for the .key file.
chmod 400 gitlab_project_keypair.key

#Obtaining Gitlab's public key and storing it in the known hosts file.
echo "--------Communicating with Gitlab...--------"
touch .ssh/known_hosts
ssh-keyscan git.cardiff.ac.uk >> .ssh/known_hosts
#Giving access to read and write of the file
chmod 644 .ssh/known_hosts

echo "--------Installing Git--------"
sudo apt install git -y

echo "-----Cloning the repository from Gitlab-----"
ssh-agent bash -c 'ssh-add gitlab_project_keypair.key && git clone git@git.cardiff.ac.uk:c23077813/team-4-smart-towns.git'

echo "-------sql-------"
sudo mysql -u root -pcomsc < /home/debian/team-4-smart-towns/src/main/resources/schema.sql
sudo mysql -u root -pcomsc < /home/debian/team-4-smart-towns/src/main/resources/data.sql

sudo apt-get update

# echo "-------Downloading Java 17--------"
# wget https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.deb

# echo "--------Installing Java 17...-------"
# sudo apt install ./jdk-17_linux-x64_bin.deb -y
# echo "--------Installing Java Runtime Environment--------"
# sudo apt install default-jre -y


# #installing gradle
# echo "--------Downloading Gradle--------"
# wget https://services.gradle.org/distributions/gradle-8.0.2-bin.zip

# echo "--------Unzipping Gradle...--------"
# sudo mkdir /opt/gradle
# sudo unzip -d /opt/gradle gradle-8.0.2-bin.zip

# echo "--------Setting up Gradle environment variables...--------"
# export PATH=$PATH:/opt/gradle/gradle-8.0.2/bin

# echo "--------Gradle Version Check--------"
# echo gradle -v

# cd /home/debian/team-4-smart-towns

# gradle build
# gradle test
# gradule bootrun

# ls /opt/gradle/

#rm jdk-17_linux-x64_bin.deb
#rm gradle-7.6.4-bin.zip

# sudo cp -pr gradle-*/* /opt/gradle

SHELL
end
