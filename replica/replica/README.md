
### Docker Compose 명령
```
docker-compose -f docker-compose.yml up -d

docker-compose -f docker-compose.yml ps

docker-compose -f docker-compose.yml down

docker-compose -f docker-compose.yml stop

docker-compose -f docker-compose.yml rm
```

### 확인
```
docker-compose exec redis redis-cli
docker-compose exec replica redis-cli
docker-compose exec replica2 redis-cli

> info replication

docker-compose stop redis
docker-compose start redis

docker-compose stop replica
docker-compose start replica
```



