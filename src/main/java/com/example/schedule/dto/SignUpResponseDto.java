package com.example.schedule.dto;

import lombok.Getter;

@Getter
public class SignUpResponseDto {

    private final Long id;

    private final String username;

    private final String email;

   // private final String password; 생성때 패스워드는 보이지 않게 하기위함

    public SignUpResponseDto(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

//    public SignUpResponseDto(Long id, String username, String email, String password) {
//        this.id = id;
//        this.username = username;
//        this.email = email;
//        this.password = password;
//    } 새로 설정했다가 유저 생성시 비밀번호는 보이지 않게 하기위해 다시 변경
}
