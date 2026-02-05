package com.example.anime.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtUtil {

    private final JwtProperties props;
    private final Key key;

    public JwtUtil(JwtProperties props) {
        this.props = props;

        String secret = props.getSecret();

        if (secret == null || secret.isBlank()) {
            throw new IllegalStateException(
                    "JWT_SECRET is missing. Define it as environment variable."
            );
        }

        if (secret.getBytes().length < 32) {
            throw new IllegalStateException(
                    "JWT_SECRET is too short. It must be at least 32 bytes (256 bits)."
            );
        }

        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateToken(Integer uid, String username) {
        return Jwts.builder()
                .setSubject(username)
                .claim("uid", uid)
                .setIssuedAt(new java.util.Date())
                .setExpiration(
                        new java.util.Date(System.currentTimeMillis() + props.getExpiration())
                )
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public String getUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public Integer getUid(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("uid", Integer.class);
    }
}
