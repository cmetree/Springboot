package me.david.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.david.springbootdeveloper.domain.User;
import me.david.springbootdeveloper.dto.AddArticleRequest;
import me.david.springbootdeveloper.dto.dto_user.AddUserRequest;
import me.david.springbootdeveloper.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


// AddUserRequest 객체를 인수로 받는 회원정보의  추가 메서드를 작성
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    //인증 성공시 실행할 핸들러를 구현,
    public Long save(AddUserRequest dto){

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return userRepository.save(User.builder()
                .email(dto.getEmail())
                // 패스워드 암호화  _ 패스워드를 저장할 때 시큐리티를 설정하며 패스워드 인코딩용으로 등록한 빈을 사용해서 암호화한 후에 저장.
                .password(encoder.encode(dto.getPassword()))
                .build()).getId();

    }

    //리프레시 토큰을 전달받아 토큰 제공자를 사용해, 새로운 액세스 토큰을 만드는 토큰 서비스
    public User findById(Long userID){
        return userRepository.findById(userID)
                .orElseThrow(()-> new IllegalArgumentException("Unexected user"));
    }

    //Oauth2 를 위한 메서드 추가

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }


}
