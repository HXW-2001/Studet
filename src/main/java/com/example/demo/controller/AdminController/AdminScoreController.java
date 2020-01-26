package com.example.demo.controller.AdminController;

import com.example.demo.pojo.Student;
import com.example.demo.service.admin.AdminScoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaoyaojiang on 2019/12/21.
 */
@Controller
public class AdminScoreController {

    @Resource
    private AdminScoreService adminScoreService;

    /**
     * 查询学生成绩以及班级
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/stuScoreList")
    public String findClass_ClassName(Model model) {
        //调用adminScoreService学生查询以及成绩方法
        List<Student> class_className = adminScoreService.findClass_ClassName();
        //把查询到的数据存进model中
        model.addAttribute("class_className", class_className);
        model.addAttribute("scoreByStu_num", null);
        //返回的页面
        return "admin/stuScoreList";
    }

    /**
     * 查询学生个人排名，以及班级平均分，班级人数
     */
    @RequestMapping(value = "/findScoreByStu_num")
    public String findScoreByStu_num(Model model, int stu_num) {
        //调用adminScoreService查询学生个人排名，以及班级平均分，班级人数方法
        Student scoreByStu_num = adminScoreService.findScoreByStu_num(stu_num);
        model.addAttribute("scoreByStu_num", scoreByStu_num);
        model.addAttribute("class_className", null);
        return "admin/stuScoreList";
    }


}
