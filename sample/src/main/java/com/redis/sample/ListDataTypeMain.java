package com.redis.sample;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;


public class ListDataTypeMain {

    public static void main(String[] args) {

        try (var jedisPool = new JedisPool("127.0.0.1", 6379)) {
            try(Jedis jedis = jedisPool.getResource()) {
//
//                // 1. stack
//                jedis.rpush("stack1", "aaa");
//                jedis.rpush("stack1", "bbb");
//                jedis.rpush("stack1", "ccc");
//
//                //List<String> stack1 = jedis.lrange("stack1", 0, -1);
//                //stack1.forEach(System.out::println);
//
//                System.out.println(jedis.rpop("stack1"));
//                System.out.println(jedis.rpop("stack1"));
//                System.out.println(jedis.rpop("stack1"));
//
//                // 2. Queue
//                jedis.rpush("queue1", "aaa");
//                jedis.rpush("queue1", "aaa");
//                jedis.rpush("queue1", "aaa");
//
//                System.out.println(jedis.rpop("queue1"));
//                System.out.println(jedis.rpop("queue1"));
//                System.out.println(jedis.rpop("queue1"));



                // 3. Block
                // CLI에서 RPUSH queue:block 100 등으로 입력으로 테스트
                while (true) {
                    List<String> block = jedis.blpop(10, "queue:block");
                    if (block != null) {
                        block.forEach(System.out::println);
                    }
                }
            }
        }
    }

}
