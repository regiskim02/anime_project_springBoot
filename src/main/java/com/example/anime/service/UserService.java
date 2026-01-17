package com.example.anime.service;

import com.example.anime.dto.LoginRequest;
import com.example.anime.dto.SignupRequest;
import com.example.anime.mapper.UserMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public String signup(SignupRequest request) {
        if (userMapper.findByUsername(request.getUsername()) != null) {
            throw new IllegalArgumentException("User already exist");
        }

        request.setPassword(passwordEncoder.encode(request.getPassword()));
        userMapper.signup(request);
        return "User created";
    }
}
