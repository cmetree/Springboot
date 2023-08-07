package com.spring.Springboot.vo;

import lombok.Builder;
import lombok.Data;

@Data
public class Vo_member {

    private String member_id;
    private String login_Id;
    private String password;
    private String name;
    private String role;
    private String reg_day;


    @Builder
    public Vo_member(String member_Id, String login_Id, String password, String name, String role, String regDay) {
        this.member_id = member_Id;
        this.login_Id = login_Id;
        this.password = password;
        this.name = name;
        this.role = role;
        this.reg_day = regDay;
    }

    public Vo_member() {
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getLogin_Id() {
        return login_Id;
    }

    public void setLogin_Id(String login_Id) {
        this.login_Id = login_Id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getReg_day() {
        return reg_day;
    }

    public void setReg_day(String reg_day) {
        this.reg_day = reg_day;
    }
}

