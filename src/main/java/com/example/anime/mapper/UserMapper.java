package com.example.anime.mapper;

import com.example.anime.domain.AnimeStatus;
import com.example.anime.domain.User;
import com.example.anime.dto.SignupRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface UserMapper {
    void signup(SignupRequest request);

    User findByUsername(String username);

    AnimeStatus findByUserAndMalId(
            @Param("userUid") int userUid,
            @Param("malId") int malId
    );

    void insertAnimeStatus(AnimeStatus status);

    void updateFavorites(@Param("userUid") int userUid,
                         @Param("malId") int malId,
                         @Param("value") String value);

    void updateWatch(@Param("userUid") int userUid,
                     @Param("malId") int malId,
                     @Param("value") String value);

    void updateCompleted(@Param("userUid") int userUid,
                         @Param("malId") int malId,
                         @Param("value") String value);

    void updatePlanToWatch(@Param("userUid") int userUid,
                           @Param("malId") int malId,
                           @Param("value") String value);

    List<AnimeStatus> findByUserUid(@Param("userUid") int userUid);
}
