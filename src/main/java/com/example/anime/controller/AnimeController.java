package com.example.anime.controller;

import com.example.anime.domain.AnimeStatus;
import com.example.anime.dto.AnimeStatusRequest;
import com.example.anime.security.AuthUser;
import com.example.anime.service.AnimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/anime")
public class AnimeController {
    private final AnimeService service;

    public AnimeController(AnimeService service) {
        this.service = service;
    }

    @PostMapping("/status")
    public ResponseEntity<?> update(@RequestBody AnimeStatusRequest request,
                                    @AuthenticationPrincipal AuthUser user) {
        service.updateStatus(user.getUid(), request);
        return ResponseEntity.ok(Map.of("status", "ok"));
    }
    @GetMapping("/status")
    public ResponseEntity<List<AnimeStatus>> getUserStatus(
            @AuthenticationPrincipal AuthUser user
    ) {
        return ResponseEntity.ok(
                service.getUserAnimeStatus(user.getUid())
        );
    }
}
