package ru.micro.demo.eurekaclient.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.micro.demo.eurekaclient.dto.JwtDto;
import ru.micro.demo.eurekaclient.service.JwtService;


import java.util.Base64;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class TestController {

    private final ObjectMapper objectMapper;

    private final JwtService jwtService;

    @GetMapping("/test")
    public String test(@RequestHeader(name = "Authorization") String token) throws JsonProcessingException {
        JwtDto jwtDto = objectMapper.readValue(jwtService.getPayload(token), JwtDto.class);
        return "Пользователь " + jwtDto.getSub() + " вошел через api gateway с помощью jwt-token!";
    }
}
