package me.david.springbootdeveloper.config.jwt;


//해당 값들을 변수로 접근하는 데 사용할 클래스(객체)


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties("jwt")// 자바 클래스에 프로피티값을 가져와서 사용하는 애너테이션
public class JwtProperties {

    private String issuer;
    private String secretKey;

}
