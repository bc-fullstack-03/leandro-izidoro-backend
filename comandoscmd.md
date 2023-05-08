docker run -d --name mongo_demo -p 27017:27017 mongo

docker exec -it mongo_demo mongosh

use db-demo

docker compose up