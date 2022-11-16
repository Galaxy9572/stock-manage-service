docker run -d \
  --name mongodb \
  --restart always \
  --privileged \
  -p 27017:27017 \
  -v /Users/liaojunyao/data/mongodb/data:/data/db \
  -e MONGO_INITDB_ROOT_USERNAME=admin \
  -e MONGO_INITDB_ROOT_PASSWORD=abcd123456 \
  mongo:6.0.2 mongod --auth