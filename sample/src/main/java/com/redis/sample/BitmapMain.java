package com.redis.sample;

import redis.clients.jedis.GeoCoordinate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.args.GeoUnit;
import redis.clients.jedis.params.GeoSearchParam;
import redis.clients.jedis.resps.GeoRadiusResponse;

import java.util.List;
import java.util.stream.IntStream;


public class BitmapMain {

    public static void main(String[] args) {

        try (var jedisPool = new JedisPool("127.0.0.1", 6379)) {
            try(Jedis jedis = jedisPool.getResource()) {

                // setbit
                jedis.setbit("request-somepage-20241114",100,true);
                jedis.setbit("request-somepage-20241114",200,true);
                jedis.setbit("request-somepage-20241114",300,true);

                // bitcount
                System.out.println(jedis.bitcount("request-somepage-20241114"));

                // getbit
                System.out.println(jedis.getbit("request-somepage-20241114", 100));
                System.out.println(jedis.getbit("request-somepage-20241114", 500));


                // bitmap vs set
                Pipeline pipeline = jedis.pipelined();
                IntStream.range(0, 100000).forEach(i -> {
                    pipeline.sadd("request-somepage-set-20241114", String.valueOf(i), "1");
                    pipeline.setbit("request-somepage-bitmap-20241114", i, true);
                    if(i==1000){
                        pipeline.sync();
                    }
                });
                pipeline.sync();

                // CLI 명령으로 메모리 사용량 비교
                // MEMORY USAGE request-somepage-set-20241114
                // MEMORY USAGE request-somepage-bitmap-20241114
            }
        }
    }

}
