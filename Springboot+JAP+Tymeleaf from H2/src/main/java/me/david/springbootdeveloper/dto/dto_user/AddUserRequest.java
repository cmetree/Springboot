package me.david.springbootdeveloper.dto.dto_user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest {

    private String email;
    private String password;

}
