package com.redis.cache.controller;

import com.redis.cache.domain.entity.User;
import com.redis.cache.repository.UserRepository;
import com.redis.cache.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RequiredArgsConstructor
@RestController
public class UserController {


    private final UserService userService;


    @GetMapping("/users/{id}")
    public User getUserEmail(@PathVariable Long id){
//        return userService.getUser(id);
        return userService.getUser3(id);
    }




    // JedisPool 활용 샘플
//    private final JedisPool jedisPool;
//    @GetMapping("/users/{id}/email")
//    public String getUserEmail(@PathVariable Long id){
//
//        var userEmailRedisKey = "users:%d:email".formatted(id);
//
//        try(Jedis jedis = jedisPool.getResource()){
//            // 1. Redis 조회
//            String userEmail = jedis.get(userEmailRedisKey);
//            if(userEmail != null){
//                return userEmail;
//            }
//
//            // 2. DB 조회 후 Redis 저장
//            userEmail = userRepository.findById(id).orElse(User.builder().build()).getEmail();
//            jedis.set(userEmailRedisKey, userEmail);
//            jedis.setex(userEmailRedisKey, 30, userEmail); // 30초 후 만료
//            return userEmail;
//        }
//    }



}
