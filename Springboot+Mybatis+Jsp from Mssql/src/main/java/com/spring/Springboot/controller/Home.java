package com.spring.Springboot.controller;

import com.spring.Springboot.service.StudyService;
import com.spring.Springboot.vo.Vo_study;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/home")
@Slf4j  // 로그내용 확인을 위해, 롬복사용(해당 어노테이션 사용 처음) _
public class Home {

        @Autowired
         StudyService studyService;

        @GetMapping("")
        public String doHome(){

            return "/WEB-INF/view/home.jsp";
        }

        @GetMapping("/study_reg")  // 명확하게
        public String doStudy_reg(HttpServletRequest request){ //model 대신, 서블릿 request 사용_서블릿 구조 이해(박차장님 요건)

                List<Vo_study> list = new ArrayList<>();
                list = studyService.doStudyList();

                for(Vo_study vo_study : list){
                    log.info(vo_study.getKEY_ID());
                    log.info(vo_study.getSTUDY_DAY());
                    log.info(vo_study.getCONTENTS());
                    log.info(vo_study.getREG_DAY());

                }

                request.setAttribute("list",list);
                // like " model.addAttribute("list,"list)

                return "/WEB-INF/view/study_reg.jsp";

        }

        @GetMapping("/member_list")
         public String member_list(){

            return "/WEB-INF/view/member_list.jsp";
         }



}
