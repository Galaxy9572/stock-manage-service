docker pull redis:5.0.14
docker run --restart=always --name redis-5.0.14 -p 6379:6379 -v D:\\Software\\Redis\\conf\\redis.conf:/etc/redis/redis.conf -v D:\\Software\\Redis\\data:/data -d redis redis-server /etc/redis/redis.conf
