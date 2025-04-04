package com.example.schedule.service;

import com.example.schedule.dto.SignUpResponseDto;
import com.example.schedule.dto.UserResponseDto;
import com.example.schedule.entity.User;
import com.example.schedule.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public SignUpResponseDto signUp(String username, String email, String password) {

        User user = new User(username, email, password);

        User savedUser = userRepository.save(user);

        return new SignUpResponseDto(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail());
    }

    public UserResponseDto findById(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exists id : " + id);
        }

        User findUser = optionalUser.get();

        return new UserResponseDto(findUser.getUsername(), findUser.getEmail());
    }

    @Transactional
    public SignUpResponseDto updateById(Long id, String newUsername, String newEmail) {

        User findUser = userRepository.findByIdOrElseThrow(id);

        findUser.updateUsername(newUsername);
        findUser.updateEmail(newEmail);

        return new SignUpResponseDto(findUser.getId(), findUser.getUsername(), findUser.getEmail());
    }

    public void delete(Long id) {

        User findUser = userRepository.findByIdOrElseThrow(id);

        userRepository.delete(findUser);

    }

    @Transactional // 비밀번호는 따로 전 비밀번호를 알아야 바꿀수 있는 형태
    public void updatePassword(Long id, String oldPassword, String newPassword) {

        User findUser = userRepository.findByIdOrElseThrow(id);

        if (!findUser.getPassword().equals(oldPassword)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }

        findUser.updatePassword(newPassword);
    }

//    public LoginResponseDto login(Long id, String email, String password) {
//
//        User findById = userRepository.findByIdOrElseThrow(id);
//
//
//
//        return new LoginResponseDto();
//    }

}
