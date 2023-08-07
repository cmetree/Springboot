package me.david.springbootdeveloper.repository;


import me.david.springbootdeveloper.domain.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//맵핑을 위해
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByUserId(Long userId);  //id찾기
    Optional<RefreshToken> findByRefreshToken(String refreshToken); // 토큰 찾기
}

