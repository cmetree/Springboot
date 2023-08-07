package me.david.springbootdeveloper.controller.controllerformodel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


//해당 url 경로로 접근하면, 메스드가 html 파일을 반환.
@Controller
public class UserViewController {

    @GetMapping("/login")
    public String login() {
        return "oauthLogin";
    } // 뷰

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

}