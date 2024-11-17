
# MYSQL 환경 구성
## 1. 컨테이너 구성
    ```bash
    docker run --name mysql -e MYSQL_ROOT_PASSWORD=1234 -d -p 3306:3306 mysql:latest
    ```
## 2. 컨테이너 접속 및 데이터베이스 생성
    ```bash
   docker exec -it mysql bash
   mysql -u root -p;
   create database fastsns;
    ```
## 3. 원격접속 허용
    ```sql
   grant all privileges on  *.* to 'root'@'%'; 
    ```

# MYSQL 실행
```bash
docker start mysql
```

# 스크립트 DDL
```sql

```