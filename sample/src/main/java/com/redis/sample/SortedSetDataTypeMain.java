package com.redis.sample;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.Set;


public class SortedSetDataTypeMain {

    public static void main(String[] args) {

        try (var jedisPool = new JedisPool("127.0.0.1", 6379)) {
            try(Jedis jedis = jedisPool.getResource()) {

                HashMap<String, Double> scores = new HashMap<>();
                scores.put("users1", 100.0);
                scores.put("users2", 30.0);
                scores.put("users3", 50.0);
                scores.put("users4", 0.0);
                scores.put("users5", 15.0);
                jedis.zadd("game2:scores", scores);

                // zrange
                jedis.zrange("game2:scores", 0, -1).forEach(System.out::println);

                // zrangeWithScores
                jedis.zrangeWithScores("game2:scores", 0, -1).forEach(System.out::println);

                // zcard
                System.out.println(jedis.zcard("game2:scores"));

                // zincrby
                jedis.zincrby("game2:scores", 100, "users5");
                jedis.zrangeWithScores("game2:scores", 0, -1).forEach(System.out::println);
            }
        }
    }

}
