# Install Docker

# curl -fsSL https://get.docker.com -o get-docker.sh

# chmod +x ./get-docker.sh

# ./get-docker.sh

# Install MySQL

apt-get update -y

apt-get install mysql-client mysql-server -y

mysql -uroot -proot -e "CREATE DATABASE xmeme;"

# Maven Installation

apt install maven -y

# Java installation

apt install default-jdk -y


# Currently in root folder of the project
cd XMeme-Backend

mvn clean install

cp target/XMeme-0.0.1-SNAPSHOT.jar XMeme.jar

cd ../