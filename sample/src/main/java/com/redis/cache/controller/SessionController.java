package com.redis.cache.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SessionController {

    /**
     * 세션 정보 조회
     * 세션 정보가 Redis에 저장 됨
     */
    @GetMapping("/session")
    public Map<String, String> getUserEmail(HttpSession session){
        Integer visitCount = (Integer) session.getAttribute("visitCount");
        if(visitCount == null){
            visitCount = 0;
        }
        session.setAttribute("visitCount", ++visitCount );
        return Map.of("session id", session.getId(), "visit count", visitCount.toString());
    }
}
