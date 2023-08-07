package com.spring.Springboot.controller;

import com.spring.Springboot.service.StudyService;
import com.spring.Springboot.vo.Vo_study;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/study_reg")
@Slf4j
public class StudyRegCon {

    @Autowired
    StudyService studyService;

    //    for insert
    @GetMapping("/insert")
    public String doIns(){

        return "/WEB-INF/view/study_ins.jsp";  //html,jsp상에서도 onclick 사용할 수 있지만 , 컨트롤러로 이동하게 만들기_ 박차장님 요건
    }

    @PostMapping("/insert_exe")  //Mybatis에서 모델과 비교하여 사용해보기
    public String doInsExe(@ModelAttribute Vo_study vo_study){

        Integer intI = studyService.doStudyIns(vo_study);  //Mybatis는 기본적으로, 업데이트를 인트형으로 받아온다.BUT int는 null을 받을 수 없으므로, INTEGER(WAPPER CLASS)필요
        // 인티져(포장객체)_ not the int(value)  _ null값을 받기 위해, int는 null을 받지 못한다 !!  ??

        return "redirect:/home/study_reg";  //리다이렉트(컨트롤러 호출!!not jsp) 사용해봄_ 여기는 같은 방향이라 의미 X
    }


    //    for update

    @GetMapping("/modify")
    public String doMod(HttpServletRequest request){

        String strKeyId = request.getParameter("key_id"); // !! JSP 페이지에서 파라미터로 넘어오는 값이 key_id_ SO, 대문자 오류남.

        Vo_study vo_study = new Vo_study();

        vo_study = studyService.doStudyListOne(strKeyId);

        request.setAttribute("vo_study",vo_study);

        return "/WEB-INF/view/study_mod.jsp";
}

    @PostMapping("/modify_exe")  //Mybatis에서 모델과 비교하여 사용해보기
    public String doModExe(@ModelAttribute Vo_study vo_study){

        Integer intI = studyService.doStudyUp(vo_study);  //Mybatis는 기본적으로, 업데이트를 인트형으로 받아온다.BUT int는 null을 받을 수 없으므로, INTEGER(WAPPER CLASS)필요
        // 인티져(포장객체)_ not the int(value)  _ null값을 받기 위해, int는 null을 받지 못한다 !!  ??

        return "redirect:/home/study_reg";  //리다이렉트(컨트롤러 호출!!not jsp) 사용해봄_ 여기는 같은 방향이라 의미 X
    }
    
    //   for delete
    @GetMapping("/delete")
     public String doDel(@RequestParam(value = "key_id", defaultValue = "--") String strKeyId){

        Integer intI = studyService.doStudyDel(strKeyId);
        log.info("intI => " +intI);  // 잘 찍히는지 보기 위해,_ 1을 가져오는 지,
        return "redirect:/home/study_reg";
    }

}
