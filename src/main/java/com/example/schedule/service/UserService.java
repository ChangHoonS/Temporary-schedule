package com.example.schedule.service;

import com.example.schedule.dto.SignUpResponseDto;
import com.example.schedule.entity.User;
import com.example.schedule.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public SignUpResponseDto signUp(String username, String email) {

        User user = new User(username, email);

        User savedUser = userRepository.save(user);

        return new SignUpResponseDto(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail());
    }
}
