package com.example.demo.controller.JumPtermController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xiaoyaojiang on 2019/12/12.
 */
@Controller
public class Teacher1Contrller {
    /**
     * 教师首页
     *
     * @return
     */
    @RequestMapping(value = "/teacher")
    public String teacher() {
        return "teacher/teacher";
    }

    /**
     * 课程查询
     *
     * @return
     */
    @RequestMapping(value = "/courseAll")
    public String courseAll() {
        return "teacher/courseAll";
    }

    /**
     * 修改个人资料
     *
     * @return
     */
    @RequestMapping(value = "/editTeacherInfo")
    public String editTeacherInfo() {
        return "teacher/editTeacherInfo";
    }

    /**
     * 查看个人资料
     *
     * @return
     */
    @RequestMapping(value = "/teacherInfo")
    public String teacherInfo() {
        return "teacher/teacherInfo";
    }

    @RequestMapping(value = "/stuTeaScore")
    public String stuTeaScore() {
        return "teacher/stuTeaScore";
    }

}
