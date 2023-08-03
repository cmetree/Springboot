package me.david.springbootdeveloper.config.jwt;

// 토큰을 생성하고 올바른 토큰인지 유효성 검사를 하고, 토큰에서 필요한 전보는 가져오는 클래스(객체)

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import me.david.springbootdeveloper.domain.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class TokenProvider {

    private final JwtProperties jwtProperties;


    public String generateToken(User user, Duration expiredAt){
        Date now = new Date();
        return makeToken(new Date(now.getTime() + expiredAt.toMillis()), user);
    }

    //JTW 토큰 생성 메서드  _인자는 만료시간,유저벙보를 받는다, 이 메서드에서는 set계열의 메서드를 통해, 여러 값을 지정한다.
    private String makeToken(Date expiry, User user){
         Date now = new Date();
          return Jwts.builder()
                .setHeaderParam(Header.TYPE,Header.JWT_TYPE) // 헤더 typ : JWT
                //내용 iss: whocdin@gmail.com(propertise 파일에서 설정한 값)
                .setIssuer(jwtProperties.getIssuer())
                .setIssuedAt(now)           // 내용 iat : 현재 시간
                .setExpiration(expiry)      // 내용 exp : expiry 멤버 변숫값
                .setSubject(user.getEmail()) //내용 sub: 유저의 이메일
                  .claim("id",user.getId()) //클레임id : 유저 ID
                //서명 : 비밀값과 함께 해시값을 HS256 방식으로 암호화
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .compact();                 //!!es256으로 지정해, 오류 발생._암복호화에서, 해싱에 차이를 보인다.!!
    }

    //JWT 토큰 유효성 검증 메서드
    public boolean validToken(String token){

        try {
            Jwts.parser()
                    .setSigningKey(jwtProperties.getSecretKey()) // 비밀값으로 복호화
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e){
            //복호화 과정에서 에러가 나면 유효하지 않은 토큰이다
            return false;
        }

    }

    //토큰 기반으로 인증 정보를 가져오는 메서드
    //-토큰을 받아 인증 정보를 담은 객체 Authentication를 반환하는 메서드,
    // 프로퍼티즈 파일에 저장한 비밀 값으로 토큰을 복호화한 뒤 클레임을 가저ㅕ오는 private 메서드인 getClaims()를 호출해서 클레임 정보를 반환받아 사용자 이메일이 들어 있는 토큰 제목 sub와 토큰 기반으로 인증정보를 생성한다.
    //
    public Authentication getAuthentication(String token) {
        Claims claims = getClaims(token);
        Set<SimpleGrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
                    // !! 첫 인자로 들어가는 User는 프로젝트에서 만든 User클래스가 아닌, 스프링 시큐리티에서 제공하는 객체인 User 클래스를 임포트해야함. !!
        return new UsernamePasswordAuthenticationToken(new org.springframework.security.core.userdetails.User(claims.getSubject
                (), "", authorities), token, authorities);
    }

    //토큰 기반으로 유저 ID를 가져오는 메서드

    public Long getUserId(String token) {
        Claims claims = getClaims(token);
        return claims.get("id", Long.class);
    }

    //클레임 조회

    private Claims getClaims(String token) {
        return Jwts.parser() // 조회
                .setSigningKey(jwtProperties.getSecretKey())
                .parseClaimsJws(token)
                .getBody();
    }

}
