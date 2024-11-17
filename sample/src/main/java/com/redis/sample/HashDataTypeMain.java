package com.redis.sample;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.Set;


public class HashDataTypeMain {

    public static void main(String[] args) {

        try (var jedisPool = new JedisPool("127.0.0.1", 6379)) {
            try(Jedis jedis = jedisPool.getResource()) {

                //hset
                HashMap<String, String> userMap = new HashMap<>();
                userMap.put("email", "test1@co.kr");
                userMap.put("phone", "010-1111-2222");
                jedis.hset("users:2:info", userMap);

                //hdel
                jedis.hdel("users:2:info", "phone");

                // hget, hgetall
                System.out.println(jedis.hget("users:2:info", "email"));
                System.out.println(jedis.hgetAll("users:2:info"));

                // hincrBy
                jedis.hincrBy("users:2:info", "visits", 1);
                jedis.hincrBy("users:2:info", "visits", 10);
                System.out.println(jedis.hgetAll("users:2:info"));
            }
        }
    }

}
