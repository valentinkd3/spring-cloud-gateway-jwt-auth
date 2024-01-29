package ru.micro.demo.eurekaclient.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class TestController {

    @GetMapping("/test")
    public String test(@RequestHeader(name = "username") String username) {
        return "Пользователь " + username + " вошел через api gateway с помощью jwt-token!";
    }
}
