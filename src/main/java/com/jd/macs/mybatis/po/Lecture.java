package com.jd.macs.mybatis.po;

/**
 * Created by machangsheng on 17/7/23.
 */
public class Lecture {

    private Long id;
    private String lectureName;
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
