package com.example.schedule.controller;

import com.example.schedule.dto.requestDto.LoginRequestDto;
import com.example.schedule.dto.requestDto.SignUpRequestDto;
import com.example.schedule.dto.responseDto.LoginResponseDto;
import com.example.schedule.dto.responseDto.SignUpResponseDto;
import com.example.schedule.dto.requestDto.UpdatePasswordRequestDto;
import com.example.schedule.dto.responseDto.UserResponseDto;
import com.example.schedule.entity.User;
import com.example.schedule.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {

        SignUpResponseDto signUpResponseDto = userService.signUp(requestDto.getUsername(), requestDto.getEmail(), requestDto.getPassword());

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.OK);
    }

    @GetMapping("/{id}") // 회원 조회에 비밀번호는 보이지 않도록 그대로 유지
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id) {

        UserResponseDto userResponseDto = userService.findById(id);

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}") //비밀번호는 여기서 바꾸지 않음
    public ResponseEntity<SignUpResponseDto> updateById(@PathVariable Long id, @RequestBody SignUpRequestDto requestDto) {

        SignUpResponseDto signUpResponseDto = userService.updateById(id, requestDto.getUsername(), requestDto.getEmail());

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponseDto> delete(@PathVariable Long id) {

        userService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{id}/update-password") //같은 PatchMapping이 겹치면 오류가 발생하니 메서드나 URL을 다르게 설정해 주자!
    public ResponseEntity<Void> updatePassword(@PathVariable Long id, @RequestBody UpdatePasswordRequestDto requestDto) {

        userService.updatePassword(id, requestDto.getOldPassword(), requestDto.getNewPassword());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto requestDto, HttpServletRequest request) {

        User loginedUser = userService.loginUser(requestDto);

        HttpSession session = request.getSession();

        session.setAttribute("SESSION_KEY", loginedUser.getId());

        LoginResponseDto loginResponseDto = new LoginResponseDto(loginedUser.getId(), "정상적으로 로그인 되었습니다.");

        return new ResponseEntity<>(loginResponseDto, HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        if(session != null) {
            session.invalidate();
        }
        return ResponseEntity.ok("로그아웃 성공");
    }






//    @PostMapping("/login")
//    public String login (@RequestBody LoginRequestDto request, HttpServletResponse response) {
//
//        userService.login(request.getEmail(), request.getPassword());
//
//    }
}
