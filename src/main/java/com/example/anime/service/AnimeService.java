package com.example.anime.service;

import com.example.anime.domain.AnimeStatus;
import com.example.anime.dto.AnimeStatusRequest;
import com.example.anime.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {
    private final UserMapper userMapper;

    public AnimeService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void updateStatus(int userUid, AnimeStatusRequest request) {
        AnimeStatus status = userMapper.findByUserAndMalId(userUid, request.getMalId());

        if (status == null) {
            AnimeStatus newStatus = new AnimeStatus();
            newStatus.setUserUid(userUid);
            newStatus.setMalId(request.getMalId());
            userMapper.insertAnimeStatus(newStatus);
        }

        switch (request.getType()) {
            case "FAVORITE" ->
                userMapper.updateFavorites(userUid, request.getMalId(), request.getValue());
            case "WATCH" ->
                userMapper.updateWatch(userUid, request.getMalId(), request.getValue());
            case "COMPLETED" ->
                userMapper.updateCompleted(userUid, request.getMalId(), request.getValue());
            case "PLAN_TO_WATCH" ->
                userMapper.updatePlanToWatch(userUid, request.getMalId(), request.getValue());
        }
    }

    public List<AnimeStatus> getUserAnimeStatus(int userUid) {
        return userMapper.findByUserUid(userUid);
    }
}
