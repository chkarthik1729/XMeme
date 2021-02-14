# Install Docker

# curl -fsSL https://get.docker.com -o get-docker.sh

# chmod +x ./get-docker.sh

# ./get-docker.sh

# Install MySQL
apt-get install mysql-client mysql-server -y

# Maven Installation

sudo apt install maven -y

# Java installation

sudo apt install default-jdk -y


# Currently in root folder of the project
cd XMeme-Backend

mvn clean install

cp target/XMeme-0.0.1-SNAPSHOT.jar XMeme.jar

cd ../