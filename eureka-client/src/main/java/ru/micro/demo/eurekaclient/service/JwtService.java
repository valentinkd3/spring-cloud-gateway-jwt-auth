package ru.micro.demo.eurekaclient.service;

import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class JwtService {

    public String getPayload(String token) {
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            String[] jwtParts = token.split("\\.");
            byte[] decode = Base64.getUrlDecoder().decode(jwtParts[1]);
            return new String(decode);
        } else {
            throw new RuntimeException("Пользователь не аутентифицирован");
        }
    }
}
