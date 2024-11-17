
### 디렉토리 설정
```
 chmod 777 ./grafana/provisioning 
 chmod 777 ./grafana/data
 chmod 777 ./prometheus/data
```    

### Docker Compose 명령
```
docker-compose -f docker-compose.yml up -d

docker-compose -f docker-compose.yml ps

docker-compose -f docker-compose.yml down

docker-compose -f docker-compose.yml stop

docker-compose -f docker-compose.yml rm
```

### Grafana 정보
```
http://localhost:3000
- admin / admin

Prometheus 데이터 소스 추가
- http://prometheus:9090

Dashboard 추가
- https://grafana.com/grafana/dashboards/14091-redis-dashboard-for-prometheus-redis-exporter-1-x/
```

### Prometheus 접속
```
http://localhost:9090
```

### Redis Exporter 접속
```
http://localhost:9121/metrics
```



