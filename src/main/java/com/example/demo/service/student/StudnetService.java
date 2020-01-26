package com.example.demo.service.student;

import com.example.demo.dao.student.StudentMapper;
import com.example.demo.pojo.ScoreCustom;
import com.example.demo.pojo.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaoyaojiang on 2019/12/15.
 */
@Service(value = "studentService")
public class StudnetService {
    @Resource
    private StudentMapper studentMapper;


    /**
     * 调用StudnetMapper学生登录方法
     *
     * @param student
     * @return
     */
    public int StudentLogin(Student student) {
        int i = 0;
        try {
            i = studentMapper.StudentLogin(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 调用随机数方法
     *
     * @param account
     * @return
     */
    public Student LoginRandow(String account) {
        Student student1 = null;
        try {
            student1 = studentMapper.LoginRandow(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student1;
    }

    /**
     * 调用StudentMapper根据id查询学生信息
     *
     * @param stu_id
     * @return
     */
    public Student findStudentByid(Integer stu_id) {
        Student student = null;
        try {
            student = studentMapper.findStudentByid(stu_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    /**
     * 调用StudnetMapper完善学生信息
     *
     * @param student
     * @return
     */
    public int updateStudent(Student student) {
        int i = 0;
        try {
            studentMapper.updateStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 调用StudnetMappe查询学生个人信息方法
     *
     * @param stu_id
     * @return
     */
    public Student findStudent(Integer stu_id) {
        Student student = null;
        try {
            student = studentMapper.findStudent(stu_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    /**
     * 调用studentMapper学生修改个人资料
     *
     * @param student
     * @return
     */
    public int updateFindStudent(Student student) {
        int i = 0;
        try {
            i = studentMapper.updateFindStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 调用studentMapper查询学生成绩信息
     *
     * @return
     */
    public List<ScoreCustom> findScore() {
        List<ScoreCustom> list = null;
        try {
            list = studentMapper.findScore();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 调用studentMapper根据学生id查询随机数
     *
     * @param stu_id
     * @return
     */
    public Student UpdFindRandow(Integer stu_id) {
        Student randow = null;
        try {
            randow = studentMapper.UpdFindRandow(stu_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return randow;
    }

    /**
     * 调用studentMapper修改密码
     *
     * @param student
     * @return
     */
    public int updatePwd(Student student) {
        int i = 0;
        try {
            i = studentMapper.updatePwd(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 修改学生头像
     *
     * @param student
     * @return
     */
    public int updateHead(Student student) {
        int i = 0;
        try {
            i = studentMapper.updateHead(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 调用studentMapper中多条件查询学生成绩
     *
     * @param student
     * @return
     */
    public List<ScoreCustom> multitermFindScore(Student student) {
        List<ScoreCustom> list = null;
        try {
            list = studentMapper.multitermFindScore(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
