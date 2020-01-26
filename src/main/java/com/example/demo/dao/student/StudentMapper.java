package com.example.demo.dao.student;

import com.example.demo.pojo.ScoreCustom;
import com.example.demo.pojo.Student;

import java.util.List;

/**
 * Created by xiaoyaojiang on 2019/12/15.
 */
public interface StudentMapper {
    /**
     * 学生用户登录
     *
     * @param student
     * @return
     */
    int StudentLogin(Student student) throws Exception;

    /**
     * 查询随机数
     *
     * @param account
     * @return
     */
    Student LoginRandow(String account) throws Exception;

    /**
     * 根据id查询学生信息
     *
     * @param stu_id
     * @return
     * @throws Exception
     */
    Student findStudentByid(Integer stu_id) throws Exception;

    /**
     * 根据编号完善学生信息
     *
     * @param student
     * @return
     * @throws Exception
     */
    int updateStudent(Student student) throws Exception;

    /**
     * 根据id查询学生个人信息
     *
     * @param stu_id
     * @return
     */
    Student findStudent(Integer stu_id) throws Exception;

    /**
     * 学生修改个人资料
     *
     * @param student
     * @return
     * @throws Exception
     */
    int updateFindStudent(Student student) throws Exception;


    /**
     * 查询学生成绩信息
     *
     * @return
     * @throws Exception
     */
    List<ScoreCustom> findScore() throws Exception;

    /**
     * 根据学生id查询随机数
     *
     * @param stu_id
     * @return
     */
    Student UpdFindRandow(Integer stu_id) throws Exception;

    /**
     * 学生修改个人密码
     *
     * @param student
     * @return
     */
    int updatePwd(Student student) throws Exception;

    /**
     * 修改学生头像
     *
     * @param student
     * @return
     */
    int updateHead(Student student) throws Exception;

    /**
     * 多条件查询学生成绩
     *
     * @param student
     * @return
     * @throws Exception
     */
    List<ScoreCustom> multitermFindScore(Student student) throws Exception;
}
