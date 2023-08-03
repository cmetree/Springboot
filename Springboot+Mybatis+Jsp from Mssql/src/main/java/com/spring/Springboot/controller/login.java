package com.spring.Springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class login {

        @GetMapping("/login")
        public String doStudy_reg(){
            return "/WEB-INF/view/login.jsp";
        }

        @GetMapping("/member_join")  // 명확하게
        public String doMember_join(){
            return "/WEB-INF/view/member_join.jsp";
        }
}
