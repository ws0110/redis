package com.redis.cache;

import com.redis.cache.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@RequiredArgsConstructor
public class RedisCacheApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(RedisCacheApplication.class, args);
    }

    private final UserRepository userRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
//        userRepository.save(com.redis.cache.domain.entity.User.builder()
//                .name("user1")
//                .email("email1")
//                .build());
//        userRepository.save(com.redis.cache.domain.entity.User.builder()
//                .name("user2")
//                .email("email2")
//                .build());
//        userRepository.save(com.redis.cache.domain.entity.User.builder()
//                .name("user3")
//                .email("email3")
//                .build());
    }

}