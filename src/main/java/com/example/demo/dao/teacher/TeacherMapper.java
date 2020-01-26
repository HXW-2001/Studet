package com.example.demo.dao.teacher;

import com.example.demo.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xiaoyaojiang on 2019/12/15.
 */
public interface TeacherMapper {


    /***
     * 查询学生所学课程
     * @return
     * @throws Exception
     */
    List<Course> findCourse_CourseName() throws Exception;

    /**
     * 添加学生账号信息
     *
     * @param student
     * @return
     * @throws Exception
     */
    int AddStudnet(Student student) throws Exception;

    //按老师身份来查询是否存在这个身份证
    int CountPrd(@Param(value = "card") String card);

    //按学生身份来查询是否存在这个身份证
    int CountStudnePad(@Param(value = "identity") String identity);

    //按老师的身份来查询是否存在账户
    int ThearchUserName(@Param(value = "account") String account);

    //按学生的身份来查询是否存在账户
    int StudentUserName(@Param(value = "account") String account);

    //按老师的身份证来查询老师账号
    int ThearchAccount(@Param(value = "card") String card, @Param(value = "account") String account);

    //按学生身份证来查询学生账号
    int StudnetAccount(@Param(value = "identity") String card, @Param(value = "account") String account);


    //新

    /**
     * 老师查询学生个人信息
     */
    List<ScoreCustom> teaCherQuery(Integer id) throws Exception;

    /**
     * 老师查询看单个学生个人信息
     */
    ScoreCustom teCherStudnets(Integer stu_num) throws Exception;


    /**
     * 老师删除一个学生
     */

    int teChereliMinationStudent(Integer stu_num) throws Exception;

    /**
     * 异步按学生学号查询是否存在此学生在学生表中（再进行添加）
     */
    List<AdditionScoreCustom> inFormation(@Param(value = "stu_num") Integer stu_num, @Param(value = "id") Integer id) throws Exception;


    /**
     * 添加学生成绩
     */
    int AddStudentScore(Score score) throws Exception;


    /**
     * 老师查看本人的个人信息（从登陆进来的session中获取到本人用户ID）
     */
    Teacher teacherPersonal(Integer id) throws Exception;


    /**
     * 查询用我们用户名查询一个随机数
     */
    Teacher teacherRandow(String Account) throws Exception;


    /**
     * 老师登陆（本人ID存入session中）
     */

    int teacherLogin(Teacher teacher) throws Exception;

    /**
     * 老师修改个人信息
     */
    int updateTeacher(Teacher teacher) throws Exception;

    /**
     * 老师查询所有老师的课程信息
     */
    Course teacherCourse(Integer id) throws Exception;


}
