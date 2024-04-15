#!/usr/bin/bash

echo "update logging configuration..."
sudo sh -c "echo '*.info;mail.none;authpriv.none;cron.none /dev/ttyS0' >> /etc/rsyslog.conf"
sudo systemctl restart rsyslog

cd /home/debian
echo in directory $PWD

echo "--------Installing wget--------"
sudo apt install wget -y
echo "--------Installing curl--------"
sudo apt install curl -y
echo "--------Installing Unzip--------"
sudo apt install unzip -y
echo "--------Installing Git--------"
sudo apt install git -y

echo "--------Installing MariaDB 10.11.2--------"
curl -LsS https://r.mariadb.com/downloads/mariadb_repo_setup | sudo bash -s -- --mariadb-server-version="mariadb-10.11.2"
sudo apt update
sudo apt install mariadb-server -y
sudo systemctl start mariadb
sudo systemctl status mariadb
sudo systemctl enable mariadb

#changing root privileges of plugin 'unix_socket' to 'mysql_native_password'
echo "--------Changing Mysql Root Access Privileges--------"
# sudo mysql -u root -e "USE mysql; SELECT User, Host, Plugin FROM mysql.user;"
sudo mysql -u root -e "UPDATE mysql.user SET plugin='mysql_native_password' WHERE User='root'";
sudo mysql -u root -e "USE mysql; UPDATE user SET password=PASSWORD('comsc') WHERE USER='root' AND HOST = 'localhost'; FLUSH PRIVILEGES;"

echo "-------Downloading Java 17--------"
wget https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.deb

echo "--------Installing Java 17...-------"
sudo apt install ./jdk-17_linux-x64_bin.deb -y
echo "--------Installing Java Runtime Environment--------"
sudo apt install default-jre -y

# echo "--------Setting up Java environment variables...--------=uneeded since JRE installs the environments and fonts"
# export JAVA_HOME=/usr/lib/jvm/jdk-17/
# export PATH=\$PATH:\$JAVA_HOME/bin
java -version

echo "upgrading sudo..."
sudo apt-get install sudo -y
sudo apt install ca-certificates 
sudo apt install gnupg2 -y
echo whoami

#installing gradle
echo "--------Downloading Gradle--------"
wget https://services.gradle.org/distributions/gradle-8.0.2-bin.zip

echo "--------Unzipping Gradle...--------"
sudo mkdir /opt/gradle
sudo unzip -d /opt/gradle gradle-8.0.2-bin.zip

echo "--------Setting up Gradle environment variables...--------"
export PATH=$PATH:/opt/gradle/gradle-8.0.2/bin

echo "--------Gradle Version Check--------"
echo gradle -v

echo "--------Installing Terraform--------"
cd /home/debian
wget https://releases.hashicorp.com/terraform/1.3.5/terraform_1.3.5_linux_amd64.zip
sudo unzip terraform_1.3.5_linux_amd64.zip
sudo mv terraform /usr/local/bin/

echo "--------Installing Jenkins--------"
## https://pkg.jenkins.io/debian/
# Import the Jenkins GPG key
sudo wget -O /usr/share/keyrings/jenkins-keyring.asc https://pkg.jenkins.io/debian-stable/jenkins.io-2023.key
# Add the Jenkins repository to the apt sources list
sudo echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] https://pkg.jenkins.io/debian-stable binary/ | sudo tee /etc/apt/sources.list.d/jenkins.list > /dev/null    
# Update the apt package index
sudo apt-get update
# Install Jenkins
sudo apt-get install jenkins -y

echo "--------Installing gitlab server key... has to be added to the jenkins user home (~) dir --------"
mkdir /var/lib/jenkins/.ssh
sudo touch /var/lib/jenkins/.ssh/known_hosts
sudo ssh-keyscan git.cardiff.ac.uk >> /var/lib/jenkins/.ssh/known_hosts
sudo chmod 644 /var/lib/jenkins/.ssh/known_hosts
sudo systemctl status jenkins

echo "--------Changing Jenkins Port to 8081--------"
sudo systemctl stop jenkins
sudo sed --i 's/"JENKINS_PORT=8080"/"JENKINS_PORT=8081"/g' /usr/lib/systemd/system/jenkins.service
sudo systemctl daemon-reload
sudo systemctl restart jenkins
sudo systemctl enable jenkins
sudo systemctl status jenkins
#/user/lib/system/jenkins.service --nothing here
# sudo nano /usr/lib/systemd/system/jenkins.service -- this works.
# /etc/default/jenkins --exists but does not change anything





# #Restricts access rights for the .key file.
# chmod 400 gitlab_project_keypair.key

# chown jenkins:jenkins /home/jenkins/.ssh/gitlab_key*
# chmod 600 /home/jenkins/.ssh/gitlab_key



