package com.example.demo.controller.AdminController;

import com.example.demo.pojo.Student;
import com.example.demo.service.admin.AdminStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaoyaojiang on 2019/12/20.
 */
@Controller
public class AdminStudentController {
    @Resource
    private AdminStudentService adminStudentService;

    /**
     * 查看学生信息
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/findTeacher_XinXi")
    public String findTeacher_XinXi(Model model) {
        List<Student> teacher_xinXi = adminStudentService.findTeacher_XinXi();
        model.addAttribute("teacher_xinXi", teacher_xinXi);
        return "admin/studentAllInfo";
    }

    /**
     * 查询所有学生账号
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/userAllInfo")
    public String findStudent_Account(Model model) {
        //调用adminStudentService的查询所有学生的方法
        List<Student> student_account = adminStudentService.findStudent_Account();
        //把查到的数据存进model中
        model.addAttribute("student_account", student_account);
        //返回的页面
        return "admin/userAllInfo";
    }

}
