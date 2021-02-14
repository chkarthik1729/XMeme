# Install Docker

curl -fsSL https://get.docker.com -o get-docker.sh

chmod +x ./get-docker.sh

./get-docker.sh


docker run --name mysqldb -p 3306:3306 -e MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_DATABASE=xmeme -e MYSQL_ROOT_PASSWORD=root -d mysql/mysql-server:latest

# Maven Installation

apt install maven -y

# Java installation

apt install default-jdk -y


# Currently in root folder of the project
cd XMeme-Backend

mvn clean install

cp target/XMeme-0.0.1-SNAPSHOT.jar XMeme.jar

cd ../