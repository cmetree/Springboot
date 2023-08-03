package me.david.springbootdeveloper.util;


//Oauth2 인증 플로우를 구현하며 쿠키를 사용할 일이 생기는데,그떄마다 쿠키를 생성하고 삭제하는 로직을 추가하면 불편하므로,
// -유틸리티로 사용할 쿠키 관리 클래스를 미리 구현

//스프링 시큐리티로 OAuth2(3자 관리)  구현하고 적용하기,
//쿠키 관리 클래스를 구현하고 OAuth2에서 제공받은 인증 객체로 사용자 정보를 가져오는 역활을 하는 서비스 구현

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.SerializationUtils;

import java.util.Base64;

public class CookieUtil {
        // 요청값(이름,값,만료 기간)을 바탕으로 쿠키 추가._HTTP 응답에 쿠키를 추가.
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);

        response.addCookie(cookie);
    }
        // 쿠키의 이름을 입력받아 쿠키 삭제_실제로 삭제하는 방법은 없으므로 파라미터로 넘어온 키의 쿠키를,빈 값으로 바꾸고,
        // 만료 시간을 0으로 설정해 쿠키가 재생성 되자마자 만료 처리
    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String name) {
        Cookie[] cookies = request.getCookies();

        if (cookies == null) {
            return;
        }

        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                cookie.setValue("");
                cookie.setPath("/");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
    }

        //객체를 직렬화해 쿠키의 값으로 변환_들어갈 값으로 변환
    public static String serialize(Object obj) {
        return Base64.getUrlEncoder()
                .encodeToString(SerializationUtils.serialize(obj));
    }

        //쿠키를 역직렬화해, 객체로 변환_
    public static <T> T deserialize(Cookie cookie, Class<T> cls) {
        return cls.cast(
                SerializationUtils.deserialize(
                        Base64.getUrlDecoder().decode(cookie.getValue())
                )
        );
    }
}

