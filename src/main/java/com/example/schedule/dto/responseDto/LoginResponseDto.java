package com.example.schedule.dto.responseDto;

import lombok.Getter;

@Getter
public class LoginResponseDto {

    private final Long id;

    private String message;


    public LoginResponseDto(Long id, String message) {
        this.id = id;
        this.message = message;
    }
}
