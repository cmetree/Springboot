package com.spring.Springboot.controller;


import com.spring.Springboot.service.MemberService;
import com.spring.Springboot.vo.Vo_member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/member")
@Slf4j
public class Con_member {

    @Autowired
    MemberService memberService;

    /* 전체 멤버 조회 */
    @GetMapping("/list")
    public String doMemberList(Model model){

        List<Vo_member> list = new ArrayList<>();
        list = memberService.doMemberList();

        model.addAttribute("list", list);


        return  "/WEB-INF/view/member_list.jsp";
    }

    /* 입력 */
    @GetMapping("/insert")
        public String doIns(){
            //System.out.println("Controller - insert");
            return "/WEB-INF/view/member_ins.jsp";
    }

    /* 등록하기 실행  */
    @PostMapping("/insert_exe")
    public String doInsExe(@ModelAttribute Vo_member vo_member){

        Integer intI = memberService.doMemberIns(vo_member);

        return "redirect:/member/list";
    }

    /* 수정 - 클릭 */
    @GetMapping("/modify")
    public String doMod(HttpServletRequest request){

        String strMemberId = request.getParameter("member_id");

        Vo_member vo_member = memberService.doMemberListOne(strMemberId);

        request.setAttribute("vo_member", vo_member);

        return "/WEB-INF/view/member_mod.jsp";
    }

    /* 수정 - 처리  */
    @PostMapping("/modify_exe")
    public String doModExe(@ModelAttribute Vo_member vo_member){

        Integer intI = memberService.doMemberUp(vo_member);

        return "redirect:/member/list";
    }


    /* 삭제 */
    @GetMapping("/delete")
    public String doDel(@RequestParam(value="member_id", defaultValue = "--") String strMemberId){

        Integer intI = memberService.doMemberDel(strMemberId);
        log.info("intI => "+intI);
        return "redirect:/member/list";
    }

}
