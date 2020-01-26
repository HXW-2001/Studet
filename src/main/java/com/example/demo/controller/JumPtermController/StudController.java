package com.example.demo.controller.JumPtermController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xiaoyaojiang on 2019/12/12.
 */
@Controller
public class StudController {
    /**
     * 学生成绩管理首页
     *
     * @return
     */
    @RequestMapping(value = "/student")
    public String student() {
        return "student/student";
    }

    /**
     * 查询个人信息
     *
     * @return
     */
    @RequestMapping(value = "/scoreOne1")
    public String scoreOne() {
        return "student/scoreOne";
    }

    /**
     * 修改个人信息
     *
     * @return
     */
    @RequestMapping(value = "/editStudentInfo")
    public String editStudentInfo() {
        return "student/editStudentInfo";
    }

    /**
     * 个人详细信息
     *
     * @return
     */
    @RequestMapping(value = "/studentInfo1")
    public String studentInfo() {
        return "student/studentInfo";
    }

    @RequestMapping(value = "updatePwd1")
    public String update() {
        return "student/updatePwd";
    }

    @RequestMapping(value = "updateTouxiang")
    public String updateTouxiang() {
        return "student/updateTouxiang";
    }
}
