package com.redis.sample;

import redis.clients.jedis.GeoCoordinate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.args.GeoUnit;
import redis.clients.jedis.params.GeoSearchParam;
import redis.clients.jedis.resps.GeoRadiusResponse;

import java.util.HashMap;
import java.util.List;


public class GeospatialMain {

    public static void main(String[] args) {

        try (var jedisPool = new JedisPool("127.0.0.1", 6379)) {
            try(Jedis jedis = jedisPool.getResource()) {

               // geoadd
               jedis.geoadd("geo:users", 127.0298553, 37.499112, "users1");
               jedis.geoadd("geo:users", 127.033333, 37.491921, "users2");

               // geodist
               Double dist = jedis.geodist("geo:users", "users1", "users2");
                System.out.println(dist);

                //geosearch
                List<GeoRadiusResponse> geoRadiusResponseList = jedis.geosearch(
                        "geo:users",
                        new GeoCoordinate(127.033, 37.495), 500, GeoUnit.M);
                geoRadiusResponseList.forEach(res -> {
                    System.out.println(res.getMemberByString());
                    System.out.println(res.getDistance());
                    System.out.println(res.getCoordinate()); // null
                });

                List<GeoRadiusResponse> geoRadiusResponseList2 = jedis.geosearch(
                        "geo:users",
                        new GeoSearchParam()
                                .fromLonLat(new GeoCoordinate(127.033, 37.495))
                                .byRadius(500, GeoUnit.M)
                                .withCoord());
                geoRadiusResponseList2.forEach(res -> {
                    System.out.println(res.getMemberByString());
                    System.out.println(res.getDistance());
                    System.out.println(res.getCoordinate()); // value exists(GeoSearchParam.withCoord())
                });

                // unlink 삭제
                jedis.unlink("geo:users");
            }
        }
    }

}
