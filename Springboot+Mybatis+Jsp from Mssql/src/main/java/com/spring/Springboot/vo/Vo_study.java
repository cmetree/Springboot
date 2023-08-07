package com.spring.Springboot.vo;


//롬복없이 진행 _ 박차장님 요건

//like DTO, But Value Object _ Read_Only 속성을 가진 (값 오프젝트) _ 단순히 값 타입을 표현하기 위하여 불변 클래스를 만들어 사용

//for Map<String,String> 를 위한 vo 객체

public class Vo_study {

    private String KEY_ID;
    private String STUDY_DAY;
    private String CONTENTS;
    private String REG_DAY;


    // Constructor
    public Vo_study(String KEY_ID, String STUDY_DAY, String CONTENTS, String REG_DAY) {
        this.KEY_ID = KEY_ID;
        this.STUDY_DAY = STUDY_DAY;
        this.CONTENTS = CONTENTS;
        this.REG_DAY = REG_DAY;
    }

    public Vo_study() {
    }

    // Getter,Setter
    public String getKEY_ID() {
        return KEY_ID;
    }

    public void setKEY_ID(String KEY_ID) {
        this.KEY_ID = KEY_ID;
    }

    public String getSTUDY_DAY() {
        return STUDY_DAY;
    }

    public void setSTUDY_DAY(String STUDY_DAY) {
        this.STUDY_DAY = STUDY_DAY;
    }

    public String getCONTENTS() {
        return CONTENTS;
    }

    public void setCONTENTS(String CONTENTS) {
        this.CONTENTS = CONTENTS;
    }

    public String getREG_DAY() {
        return REG_DAY;
    }

    public void setREG_DAY(String REG_DAY) {
        this.REG_DAY = REG_DAY;
    }
}
