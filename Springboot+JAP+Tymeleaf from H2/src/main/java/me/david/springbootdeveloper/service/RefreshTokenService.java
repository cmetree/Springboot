package me.david.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.david.springbootdeveloper.domain.RefreshToken;
import me.david.springbootdeveloper.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;



@RequiredArgsConstructor
@Service
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    //전달받은 리프레시 토큰으로 리프레시 토큰 객체를 건색해서 전달하는 메서드 구현
    public RefreshToken findByRefreshToken(String refreshToken){
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(()-> new IllegalArgumentException("Unexpected token"));
    }

}
