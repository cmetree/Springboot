package me.david.springbootdeveloper.dto.dtoForToken;


//토큰 생성 요청 및 응답을 담당할 클래스

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class CreateAccessTokenResponse {

    private String accessToken;


}
