package com.example.demo.dao.admin;

import com.example.demo.pojo.Student;

import java.util.List;

/**
 * Created by xiaoyaojiang on 2019/12/21.
 */
public interface AdminScoreMapper {

    /**
     * 查询学生班级及分数排名
     *
     * @return
     */
    List<Student> findClass_ClassName() throws Exception;

    /**
     * 查询学生个人排名，以及班级平均分，班级人数
     *
     * @param stu_num
     * @return
     * @throws Exception
     */
    Student findScoreByStu_num1(int stu_num) throws Exception;
}
