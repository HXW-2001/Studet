package com.example.demo.service.admin;

import com.example.demo.dao.admin.AdminStudentMapper;
import com.example.demo.pojo.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaoyaojiang on 2019/12/20.
 */
@Service(value = "AdminStudentService")
public class AdminStudentService {
    @Resource
    private AdminStudentMapper adminStudentMapper;

    /**
     * 查询学生信息
     *
     * @return
     */
    public List<Student> findTeacher_XinXi() {
        List<Student> list = null;
        try {
            list = adminStudentMapper.findTeacher_XinXi();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 查询所有学生账号
     *
     * @return
     */
    public List<Student> findStudent_Account() {
        List<Student> students = null;
        try {
            students = adminStudentMapper.findStudent_Account();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

}
