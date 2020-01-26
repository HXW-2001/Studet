package com.example.demo.dao.admin;

import com.example.demo.pojo.Student;

import java.util.List;

/**
 * Created by xiaoyaojiang on 2019/12/20.
 */
public interface AdminStudentMapper {

    /**
     * 查询学生成绩
     *
     * @return
     */
    List<Student> findTeacher_XinXi() throws Exception;

    /**
     * 查询所有学生账号
     *
     * @return
     * @throws Exception
     */
    List<Student> findStudent_Account() throws Exception;


}
