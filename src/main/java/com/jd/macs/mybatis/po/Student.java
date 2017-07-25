package com.jd.macs.mybatis.po;

import com.jd.macs.mybatis.enums.Sex;

/**
 * Created by machangsheng on 17/7/23.
 */
public class Student {

    private Long id;
    private String cnname;
    private Sex sex;
    private String note;

    private StudentSelfcard studentSelfcard;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public StudentSelfcard getStudentSelfcard() {
        return studentSelfcard;
    }

    public void setStudentSelfcard(StudentSelfcard studentSelfcard) {
        this.studentSelfcard = studentSelfcard;
    }
}
