package com.jd.macs.mybatis.mapper;

import com.jd.macs.mybatis.po.Student;

/**
 * Created by machangsheng on 17/7/23.
 */
public interface StudentMapper {

    int insertStudent(Student student);
    Student findStudent(Long id);
}
