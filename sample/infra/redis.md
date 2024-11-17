
### Redis Docker 
```
docker run --name redis -d -p 6379:6379 redis
```
참조: https://msyu1207.tistory.com/entry/Redis-PubSub#google_vignette

### Start
```
docker start redis
```

### 접속
```
docker exec -it redis redis-cli

keys *
```




### Cient UI Tool
https://github.com/patrikx3/redis-ui/releases


