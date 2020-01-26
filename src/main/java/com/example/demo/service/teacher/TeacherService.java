package com.example.demo.service.teacher;

import com.example.demo.dao.teacher.TeacherMapper;
import com.example.demo.pojo.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaoyaojiang on 2019/12/15.
 */
@Service(value = "teacherService")
public class TeacherService {
    @Resource
    private TeacherMapper teacherMapper;


    /***
     * 调用StudentMapper查询学生所学课程
     * @return
     */
    public List<Course> findCourse_CourseName() {
        List<Course> course = null;
        try {
            course = teacherMapper.findCourse_CourseName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return course;
    }


    /**
     * 调用StudentMapper添加学生账号方法
     *
     * @param student
     * @return
     */
    public int AddStudnet(Student student) {
        int i = 0;
        try {
            i = teacherMapper.AddStudnet(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    //按老师身份来查询是否存在这个身份证
    public int CountPrd(String card) {
        int i = 0;
        try {
            i = teacherMapper.CountPrd(card);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    //按学生身份来查询是否存在这个身份证
    public int CountStudnePad(String identity) {
        int i = 0;
        try {
            i = teacherMapper.CountStudnePad(identity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    //按老师身份来查询是否存在这个账户
    public int ThearchUserName(String account) {
        int i = 0;
        try {
            i = teacherMapper.ThearchUserName(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    //按学生身份来查询是否存在这个账户
    public int StudentUserName(String account) {
        int i = 0;
        try {
            i = teacherMapper.StudentUserName(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    //按老师的身份证来查询老师账户
    public int ThearchAccount(String card, String account) {
        int i = 0;
        try {
            i = teacherMapper.ThearchAccount(card, account);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    //按学生的身份证来查询学生账户
    public int StudnetAccount(String identity, String account) {
        int i = 0;
        try {
            i = teacherMapper.StudnetAccount(identity, account);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }


    //新

    /**
     * 老师查询学生的个人信息
     */
    public List<ScoreCustom> teaCherQuery(Integer id) {
        List<ScoreCustom> list = null;
        try {
            list = teacherMapper.teaCherQuery(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 老师按ID查询单个学生的个人信息
     */
    public ScoreCustom teCherStudnets(int stu_num) {
        ScoreCustom student = null;
        try {
            student = teacherMapper.teCherStudnets(stu_num);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    /**
     * 老师删除一个学生信息
     */
    public int teChereliMinationStudent(Integer stu_num) {
        int i = 0;
        try {
            i = teacherMapper.teChereliMinationStudent(stu_num);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 异步按学生学号查询是否存在此学生在学生表中（再进行添加）
     */

    public List<AdditionScoreCustom> inFormation(Integer stu_num, Integer id) {
        List<AdditionScoreCustom> list = null;
        try {
            list = teacherMapper.inFormation(stu_num, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 老师添加学生成绩
     *
     * @param score
     * @return
     */
    public int AddStudentScore(Score score) {
        int i = 0;
        try {
            i = teacherMapper.AddStudentScore(score);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;

    }


    /**
     * 老师查询自己的一个个人信息
     *
     * @param id
     * @return
     */
    public Teacher teacherPersonal(Integer id) {
        Teacher teacher = null;
        try {
            teacher = teacherMapper.teacherPersonal(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teacher;
    }


    /**
     * 老师登陆本人账号
     */
    public int teacherLogin(Teacher teacher) {
        int teachers = 0;
        try {
            teachers = teacherMapper.teacherLogin(teacher);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teachers;
    }

    /**
     * 根据登陆账号查询登陆者的随机数
     */
    public Teacher teacherRandow(String account) {
        Teacher teachers = null;
        try {
            teachers = teacherMapper.teacherRandow(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teachers;
    }

    /**
     * 老师修改个人信息
     *
     * @param
     * @return
     */
    public int updateTeacher(Teacher teacher) {
        int i = 0;
        try {
            i = teacherMapper.updateTeacher(teacher);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }


    /**
     * 老师查看课程信息
     */
    public Course teacherCourse(Integer id) {
        Course course = null;
        try {
            course = teacherMapper.teacherCourse(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return course;

    }


}
