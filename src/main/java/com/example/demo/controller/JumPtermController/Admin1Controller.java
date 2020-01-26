package com.example.demo.controller.JumPtermController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xiaoyaojiang on 2019/12/11.
 */
@Controller
public class Admin1Controller {


    @RequestMapping(value = "/login")
    public String hhh() {
        return "login/login";
    }

    @RequestMapping(value = "/register")
    public String register() {
        return "register/register";
    }

    @RequestMapping(value = "/admin")
    public String update() {
        return "admin/admin";
    }

    @RequestMapping(value = "/adminc")
    public String fff() {
        return "admin/courseAllInfo";
    }

    @RequestMapping(value = "/scoreOne")
    public String bbbbb() {
        return "student/scoreOne";
    }

    @RequestMapping(value = "/selectInfo")
    public String selectInfo() {
        return "admin/selectInfo";
    }

    @RequestMapping(value = "/courseAllInfo")
    public String courseAllInfo() {
        return "admin/courseAllInfo";
    }

    @RequestMapping(value = "/selectblurScore")
    public String selectblurScore() {
        return "admin/selectblurScore";
    }

    @RequestMapping(value = "/addScore")
    public String addScore() {
        return "admin/addScore";
    }

    @RequestMapping(value = "/teacherAllInfo")
    public String teacherAllInfo() {
        return "admin/teacherAllInfo";
    }

    @RequestMapping(value = "/addTeacher")
    public String addTeacher() {
        return "admin/addTeacher";
    }
}
