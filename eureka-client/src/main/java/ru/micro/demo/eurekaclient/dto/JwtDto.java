package ru.micro.demo.eurekaclient.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtDto {

    private String sub;

    private long iat;

    private long exp;
}
