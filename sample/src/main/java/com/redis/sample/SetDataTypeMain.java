package com.redis.sample;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Set;


public class SetDataTypeMain {

    public static void main(String[] args) {

        try (var jedisPool = new JedisPool("127.0.0.1", 6379)) {
            try(Jedis jedis = jedisPool.getResource()) {

                jedis.sadd("users:500:follow", "100", "200", "300");
                jedis.srem("users:500:follow", "100");

                Set<String> smembers = jedis.smembers("users:500:follow");
                smembers.forEach(System.out::println);

                System.out.println(jedis.sismember("users:500:follow", "100"));
                System.out.println(jedis.sismember("users:500:follow", "200"));

                jedis.sadd("users:100:follow", "150", "200", "350");
                Set<String> sinters = jedis.sinter("users:500:follow", "users:100:follow");
                sinters.forEach(System.out::println);
            }
        }
    }

}
