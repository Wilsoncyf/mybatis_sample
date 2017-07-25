package com.jd.macs.mybatis.po;

import java.util.List;

/**
 * Created by machangsheng on 17/7/25.
 */
public class FemaleStudent extends Student {

    private List<StudentHealthFeMale> studentHealthFeMaleList;

    public List<StudentHealthFeMale> getStudentHealthFeMaleList() {
        return studentHealthFeMaleList;
    }

    public void setStudentHealthFeMaleList(List<StudentHealthFeMale> studentHealthFeMaleList) {
        this.studentHealthFeMaleList = studentHealthFeMaleList;
    }
}
