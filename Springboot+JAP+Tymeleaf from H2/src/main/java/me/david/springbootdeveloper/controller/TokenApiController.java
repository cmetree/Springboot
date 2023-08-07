package me.david.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.david.springbootdeveloper.dto.dtoForToken.CreateAccessTokenRequest;
import me.david.springbootdeveloper.dto.dtoForToken.CreateAccessTokenResponse;
import me.david.springbootdeveloper.service.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


//실제로 요청을 받고 처리할 컨트롤러,
//요청이 오면, 토큰 서비스에서 리프레시 토큰을 기반으로 새로운 액세스 토큰을 만들어 준다.
@RequiredArgsConstructor
@RestController
public class TokenApiController {

    private final TokenService tokenService;

    @PostMapping("/api/token")
    public ResponseEntity<CreateAccessTokenResponse> createNewAccessToken(@RequestBody CreateAccessTokenRequest request) {
        String newAccessToken = tokenService.createNewAccessToken(request.getRefreshToken());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CreateAccessTokenResponse(newAccessToken));
    }
}