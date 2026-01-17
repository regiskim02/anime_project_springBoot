package com.example.anime.mapper;

import com.example.anime.domain.User;
import com.example.anime.dto.SignupRequest;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
    void signup(SignupRequest request);

    User findByUsername(String username);
}
