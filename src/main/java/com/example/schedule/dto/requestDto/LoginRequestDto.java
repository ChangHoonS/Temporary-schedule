package com.example.schedule.dto.requestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginRequestDto {

    @NotBlank(message = "아이디 입력은 필수입니다.")
    private final String email;

    @NotBlank(message = "비밀번호 입력은 필수입니다.")
    @NotEmpty(message = "비밀번호를 입력해주세요.")
    private final String password;

}
