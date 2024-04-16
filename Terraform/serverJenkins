# -*- mode: ruby -*-
# vi: set ft=ruby :

# All Vagrant configuration is done below. The "2" in Vagrant.configure
# configures the configuration version (we support older styles for
# backwards compatibility). Please don't change it unless you know what
# you're doing.
Vagrant.configure("2") do |config|
  # The most common configuration options are documented and commented below.
  # For a complete reference, please see the online documentation at
  # https://docs.vagrantup.com.

  # Every Vagrant development environment requires a box. You can search for
  # boxes at https://vagrantcloud.com/search.
  config.vm.box = "debian/buster64"

  # Disable automatic box update checking. If you disable this, then
  # boxes will only be checked for updates when the user runs
  # `vagrant box outdated`. This is not recommended.
  # config.vm.box_check_update = false

  # Create a forwarded port mapping which allows access to a specific port
  # within the machine from a port on the host machine. In the example below,
  # accessing "localhost:8080" will access port 80 on the guest machine.
  # NOTE: This will enable public access to the opened port
  config.vm.network "forwarded_port", guest: 8080, host: 8084

  # Create a forwarded port mapping which allows access to a specific port
  # within the machine from a port on the host machine and only allow access
  # via 127.0.0.1 to disable public access
  # config.vm.network "forwarded_port", guest: 80, host: 8080, host_ip: "127.0.0.1"

  # Create a private network, which allows host-only access to the machine
  # using a specific IP.
  # config.vm.network "private_network", ip: "192.168.33.10"

  # Create a public network, which generally matched to bridged network.
  # Bridged networks make the machine appear as another physical device on
  # your network.
  # config.vm.network "public_network"

  # Share an additional folder to the guest VM. The first argument is
  # the path on the host to the actual folder. The second argument is
  # the path on the guest to mount the folder. And the optional third
  # argument is a set of non-required options.
  # config.vm.synced_folder "../data", "/vagrant_data"

  # Provider-specific configuration so you can fine-tune various
  # backing providers for Vagrant. These expose provider-specific options.
  # Example for VirtualBox:
  #
  config.vm.provider "virtualbox" do |vb|
    # Display the VirtualBox GUI when booting the machine
    # vb.gui = true
  
    # Customize the amount of memory on the VM:
    vb.memory = "2048"
  end
  #
  # View the documentation for the provider you are using for more
  # information on available options.

  # Enable provisioning with a shell script. Additional provisioners such as
  # Puppet, Chef, Ansible, Salt, and Docker are also available. Please see the
  # documentation for more information about their specific syntax and use.
  # config.vm.provision "shell", inline: <<-SHELL
  #   apt-get update
  #   apt-get install -y apache2
  # SHELL
config.vm.synced_folder ".", "/vagrant", type: "rsync", disabled: true
config.vm.provision "shell", privileged: false, inline: <<-SHELL
#whoami

echo "--------Installing MariaDB--------"
sudo apt update
sudo apt install mariadb-server -y
sudo systemctl start mariadb
sudo systemctl status mariadb
sudo systemctl enable mariadb

#changing root privileges of plugin 'unix_socket' to 'mysql_native_password'
echo "--------Changing mysql root access privileges--------"
# sudo mysql -u root -e "USE mysql; SELECT User, Host, Plugin FROM mysql.user;"
sudo mysql -u root -e "UPDATE mysql.user SET plugin='mysql_native_password' WHERE User='root'";
sudo mysql -u root -e "USE mysql; UPDATE user SET password=PASSWORD('comsc') WHERE USER='root' AND HOST = 'localhost'; FLUSH PRIVILEGES;"
echo "--------Privileges changed--------"


## mysql_secure_installation not needed ???
# Creating mysql_secure_installation.txt, and running it.
# echo "creating mysql_secure_installation.txt..."
# touch mysql_secure_installation.txt
# cat << `EOF` >> mysql_secure_installation.txt

# n
# Y
# comsc
# comsc
# Y
# Y
# Y
# Y
# Y
# `EOF`

# echo "running mysql_secure_installation..."
# sudo mysql_secure_installation < mysql_secure_installation.txt


cat << `EOF` >> gitlab_project_keypair.key
-----BEGIN OPENSSH PRIVATE KEY-----
b3BlbnNzaC1rZXktdjEAAAAABG5vbmUAAAAEbm9uZQAAAAAAAAABAAABlwAAAAdzc2gtcn
NhAAAAAwEAAQAAAYEA7kUPgwMm77dCHgPofrHHqlfYCoz7zrd8vYv+bum5hEI7q2c8UeyX
vwlFwhy20irxZlv2ku64xOAPWq6AjJlF2vHvKH94tUzL9ANbDsX+6OnK7q2oOlP+/VB9K5
Y3uflcuupSq1GL1xtzJkA7Rma7oCbBUcCcu2ieqPMZPcMQTSllBa4QIMMgxj3uPWCxbG2e
4nZsH0VcO7/BrDzgtx1vmVz9JcYRFYQq439/EbB+9yrA9u7LF943bC3CBVODZn/HZ9FAtF
cVpP2a7AncRK1Y/xyjqIgiuabiikg3Z10yLU89pmaKIgiNtpayRyBdbekE0HdcaZj+/uRr
S1o0L5RCHbaKEl/6Blt9U10SmiRBBIWs7kYG0QZgWhp3pM0dxyS+BgAjM57QMqplzJOXC9
pd3X6P3jvp+uGfFF2/JPpOqcH44sZMeCKPgac4wZoBLfRkkFpsS7V7jBMVE7S2+SR1Q3hJ
G7h/LJc/qhyXH7qNhEwtD7F/QR85/afiydoWLmdpAAAFmJTFjYKUxY2CAAAAB3NzaC1yc2
EAAAGBAO5FD4MDJu+3Qh4D6H6xx6pX2AqM+863fL2L/m7puYRCO6tnPFHsl78JRcIcttIq
8WZb9pLuuMTgD1qugIyZRdrx7yh/eLVMy/QDWw7F/ujpyu6tqDpT/v1QfSuWN7n5XLrqUq
tRi9cbcyZAO0Zmu6AmwVHAnLtonqjzGT3DEE0pZQWuECDDIMY97j1gsWxtnuJ2bB9FXDu/
waw84Lcdb5lc/SXGERWEKuN/fxGwfvcqwPbuyxfeN2wtwgVTg2Z/x2fRQLRXFaT9muwJ3E
StWP8co6iIIrmm4opIN2ddMi1PPaZmiiIIjbaWskcgXW3pBNB3XGmY/v7ka0taNC+UQh22
ihJf+gZbfVNdEpokQQSFrO5GBtEGYFoad6TNHcckvgYAIzOe0DKqZcyTlwvaXd1+j9476f
rhnxRdvyT6TqnB+OLGTHgij4GnOMGaAS30ZJBabEu1e4wTFRO0tvkkdUN4SRu4fyyXP6oc
lx+6jYRMLQ+xf0EfOf2n4snaFi5naQAAAAMBAAEAAAGABX9CZFtmQpGPzPF6I7ImUR/FtD
icdqB1GEpqjFSIGy0MA2BWW+2Bcr7cBSZ0cVTcTOhCQBGR4bjpocX04UmH+w0p311Rg51J
9088gpK+1tDOBcOr5eyaLW319VN55aiDIyzUy28OMuBHP9Kri2xDV+aM/z3aX9iCEJPLOU
mOzrjtw7vIU3ktAGXdYT0h2saMq9zfkbkf76D07uxYouDi+j7S+FQhgMWT17vRSq8vvrQV
z5yiwuI1lSFZIJZUqcC45Z7XWhTpu4VYUghB4xX4G4Vc/lskeoemTvd1BXFevnMTN7pR7I
wLnDwXMAzOsGF79Al5gV43Xr588AVpFD9zrScBzdOO1eq+sz2vWJXMHWaRukz3ywGDpsmr
qT8qfeu/H/QjcJYX3RZDbHJNMlNiOVjGw/jUf2jxUIUuIOD88ljKBS4X98YSYubPS/wItI
Ni3GyTyoWi3+rV6crxYILRy1B63x6axh5ttGnwTBsJk2J6ePxT7SthjaNaLX90PxAhAAAA
wHlBtGVIpuOcI3DsHIz5GwZ5RgMXPiK8gYXh5/MOrnq17AamoTPhzltO0tKm9YhFLWZ3zb
Y+P6xZJamIY5HbsNfDS8oKvlIm4u2/Sm+sE9jt8h6C+HoxPSd0ULusfqjTt4yarmRhPsrh
MZw5FchZgck5gbH40YwXTvkbeX8ydGQ+5Dk7GQwMcL5lLO1NopNzE55A9rpk4vIgmCdFp3
2mr4m6nAMPhPnFh7AxD6d+6358wduyCQTKeNuBFRMMrqVr8QAAAMEA+B9xH66carC5cq9J
GXFdhheD3H379luZG4In8y5+zJYYh6DyAn4qG3hSYfmqy/Jztw2sfUyPmHwQRGxzAhdByk
N5CislyjAj+zdMWd5B/g68n5jRjSoMXS36//+6qA8KmhooNwpJn5D59GvIH6TALXl7maqV
ImwJJxhczlPzZwEtM5XEM/kM895B4MQ8adhD0uY00MHEEVswOXMJNKqHCvkiW2os1Zat8h
wQqZRGP9o7bUGTq9BhNGQNfdICka5HAAAAwQD11YpYVo7Tg8PH0RtoNgYOcWWZ5nRdAgCG
La50dGz5eTOLjGz4mp3NSSOYn3YoB3EC0mZMg9g2AiUZfn/hi+nf3OTeqeGHwOqd1saLQS
MOIxuBA4qaU8BL8CLAxKCRKSn9oa5Vt6qbixzTH2cyi4iRtn/S27/PaUXDiVZ6BC9aKbUA
cK0y4rXcJLKuJ5lUWS+r8MtF4oyMtugh5mQKMxs8LNWMlcoXIyOF8i7AFRAACKfnuDs+vM
cBUsOLaqjbpM8AAAAcSUQrYzIzMDc3ODEzQERTQTEwRjYwQThGNTQ2MgECAwQFBgc=
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
echo "--------Installing Gitlab...--------"
sudo apt install git -y

#Cloning the repository from Gitlab.
ssh-agent bash -c 'ssh-add gitlab_project_keypair.key && git clone git@git.cardiff.ac.uk:c23077813/team-4-smart-towns.git'

# cd team-4-smart-towns
mysql -u root -pcomsc < team-4-smart-towns/src/main/resources/schema.sql

sudo apt update
sudo apt -y install wget curl

#installing java
echo "-------Downloading Java 17...--------"
wget https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.deb

echo "--------Installing Java 17...--------"
sudo apt install ./jdk-17_linux-x64_bin.deb -y

# echo "--------Setting up Java environment variables...--------"
# export JAVA_HOME=/usr/lib/jvm/jdk-17/
# export PATH=\$PATH:\$JAVA_HOME/bin

java -version

#installing unzip
echo "--------Installing Unzip--------"
sudo apt install unzip

#installing gradle
echo "--------Downloading Gradle--------"
wget https://services.gradle.org/distributions/gradle-8.0.2-bin.zip

echo "--------Unzipping Gradle...--------"
sudo mkdir /opt/gradle
sudo unzip -d /opt/gradle gradle-8.0.2-bin.zip


echo "--------Setting up Gradle environment variables...--------"
export PATH=$PATH:/opt/gradle/gradle-8.0.2/bin

echo "--------Gradle Bootrun...--------"
gradle -v

gradle build
gradle test
gradule bootrun

# ls /opt/gradle/

#rm jdk-17_linux-x64_bin.deb
#rm gradle-7.6.4-bin.zip

# sudo cp -pr gradle-*/* /opt/gradle

SHELL
end
