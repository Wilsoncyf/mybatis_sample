package com.jd.macs.mybatis.po;

import java.util.List;

/**
 * Created by machangsheng on 17/7/25.
 */
public class MaleStudent extends Student {

    private List<StudentHealthMale> studentHealthMaleList;

    public List<StudentHealthMale> getStudentHealthMaleList() {
        return studentHealthMaleList;
    }

    public void setStudentHealthMaleList(List<StudentHealthMale> studentHealthMaleList) {
        this.studentHealthMaleList = studentHealthMaleList;
    }
}
