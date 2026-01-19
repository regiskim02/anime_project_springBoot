package com.example.anime.service;

import com.example.anime.domain.User;
import com.example.anime.dto.LoginRequest;
import com.example.anime.dto.SignupRequest;
import com.example.anime.mapper.UserMapper;
import com.example.anime.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UserService(UserMapper userMapper, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public String signup(SignupRequest request) {
        if (userMapper.findByUsername(request.getUsername()) != null) {
            throw new IllegalArgumentException("User already exist");
        }

        request.setPassword(passwordEncoder.encode(request.getPassword()));
        userMapper.signup(request);
        return "User created";
    }

    public String login(LoginRequest request) {

        User user = userMapper.findByUsername(request.getUsername());
        if (user == null) {
            throw new IllegalArgumentException("User does not exist.");
        }
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid password.");
        }

        return jwtUtil.generateToken(
                user.getUid(),
                user.getUsername()
        );
    }
}
