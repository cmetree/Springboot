package me.david.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

//회원 엔터티와 매핑할 테이블의 구조
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User implements UserDetails { //UserDetails를 상속받아 인증 객체로 사용

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password")  // 여기서 null 불가능하게 지정해둔 것이 문제가 되었다.
    private String password;

    @Builder
    public User(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }


    @Override //권한 반환
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override // 사용자의 id를 반환(고유한 값)
    public String getUsername() {
        return email;
    }

    @Override// 사용자의 패스워드를 반환
    public String getPassword() {
        return password;
    }

    @Override //계정 만료 여부 반환
    public boolean isAccountNonExpired() {
        //계정 잠금되었는지 확인하는 로직

        return true; //-> 만료되지 않았음.
    }

    //계정 잠금 여부 반환
    @Override
    public boolean isAccountNonLocked() {
        // 계정 잠금되었는지 확인하는 로직

        return true; //->만료되지 않았음
    }

    //패스워드의 만료 여부 반환
    @Override
    public boolean isCredentialsNonExpired() {
        //패스워드가 만료되었는지 확인하는 로직
        return true; //->만료되지 않았음
    }
    //계정 사용 가능 여부 반환
    @Override
    public boolean isEnabled() {
        //계정이 사용 가능한지 확인하는 로직
        return true; //->사용 가능
    }

    //<Oauth>
    //사용자 정보를 조회해 users 테이블에 사용자 정보가 있다면 리소스 서버에서 제공해주는 이름을 업데이트
    // 없다면, 테이블에 새 사용자를 생성해, 데이터베이스에 저장하는 서비스를 구현

    //사용자 이름
    @Column(name = "nickname",unique = true)
    private String nickname;

    public User update(String nickname){
        this.nickname = nickname;

        return this;
    }


}
