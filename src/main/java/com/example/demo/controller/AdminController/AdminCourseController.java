package com.example.demo.controller.AdminController;

import com.example.demo.pojo.Course;
import com.example.demo.pojo.Teacher;
import com.example.demo.service.admin.AdminCourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaoyaojiang on 2019/12/19.
 */
@Controller
public class AdminCourseController {
    @Resource
    private AdminCourseService adminCourseService;


    /**
     * 查询所有班级名称
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/addCourse")
    public String findClassName(Model model) {
        //调用查询班级名称方法
        List<Class> className = adminCourseService.findClassName();
        //调用查询所有老师名字
        List<Teacher> tea_name = adminCourseService.findTea_name();
        //把查到的值放进model中
        model.addAttribute("className", className);
        //把查到的值放进model中
        model.addAttribute("tea_name", tea_name);
        //返回的页面
        return "admin/addCourse";
    }


    /**
     * 添加课程信息
     *
     * @param course2
     * @return
     */
    @RequestMapping(value = "/courseAdd")
    public String courseAdd(Course course2, Model model) {
        //调用courseService添加课程信息方法
        int i = adminCourseService.courseAdd(course2);
        if (i > 0) {

            //调用courseService查看课程方法
            List<Course> course = adminCourseService.findCourse();
            //把查到的数据放进model中
            model.addAttribute("course", course);
            //返回的页面
            return "admin/courseAllInfo";
        }
        //添加失败返回的页面
        return "addCourse";
    }

    /**
     * 查看课程
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/findCourse")
    public String findCourse(Model model) {
        //调用courseService查看课程方法
        List<Course> course = adminCourseService.findCourse();
        //把查到的数据放进model中
        model.addAttribute("course", null);
        model.addAttribute("course", course);
        //返回的页面
        return "admin/teacherInfo";
    }

    /**
     * 根据course_id查询老师代课信息
     *
     * @param course_id
     * @param model
     * @return
     */
    @RequestMapping(value = "/findCourseByCourse_id")
    public String findCourseByCourse_id(int course_id, Model model) {
        //调用adminCourseService根据course_id查询老师代课信息
        Course courseByCourse_id = adminCourseService.findCourseByCourse_id(course_id);
        //调用查询班级名称方法
        List<Class> className = adminCourseService.findClassName();
        //调用查询所有老师名字
        List<Teacher> tea_name = adminCourseService.findTea_name();
        //把查到的值放进model中
        model.addAttribute("className", className);
        //把查到的值放进model中
        model.addAttribute("tea_name", tea_name);
        model.addAttribute("courseByCourse_id", null);
        //把查询到的数据存进model中
        model.addAttribute("courseByCourse_id", courseByCourse_id);
        //返回的页面
        return "admin/teacherInfo";
    }

    /**
     * 修改科目信息
     *
     * @param course1
     * @return
     */
    @RequestMapping(value = "/updateCourse")
    public String updateCourse(Course course1, Model model) {
        int i = adminCourseService.updateCourse(course1);
        //调用courseService查看课程方法
        List<Course> course = adminCourseService.findCourse();
        //把查到的数据放进model中
        model.addAttribute("course", null);
        model.addAttribute("course", course);
        //返回的页面
        return "admin/teacherInfo";
    }
}
