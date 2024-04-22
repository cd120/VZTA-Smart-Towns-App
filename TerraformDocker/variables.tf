variable "flavor" { default = "m1.large" }
variable "image" { default = "Debian Buster 10.11.1 20211029" }

variable "name" { default = "DebianJenkinsServer" }

variable "network" { default = "c23077813_network" }   # you need to change this

variable "keypair" { default = "username_keypair" } # you need to change this
variable "pool" { default = "cscloud_private_floating" }
variable "server_script" { default = "./server2.sh" }
variable "security_description" { default = "Terraform security group" }
variable "security_name" { default = "tf_security_docker" }
