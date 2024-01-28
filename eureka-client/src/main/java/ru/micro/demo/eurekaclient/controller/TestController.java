package ru.micro.demo.eurekaclient.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Base64;

@RestController
@RequestMapping("/client")
public class TestController {

    @GetMapping("/test")
    public String test(@RequestHeader(name = "Authorization") String header) throws JsonProcessingException {
        String token = header.substring(7);
        String[] jwtParts = token.split("\\.");
        byte[] decode = Base64.getUrlDecoder().decode(jwtParts[1]);
        String jsonString = new String(decode);
        ObjectMapper objectMapper = new ObjectMapper();
        JwtDto jwtDto = objectMapper.readValue(jsonString, JwtDto.class);

        return "Пользователь " + jwtDto.getSub() + " вошел через апи-гетувэй с токеном!";
    }
}
