package com.example.demo.controller.TeacherController;

import com.example.demo.pojo.*;
import com.example.demo.service.admin.AdminCourseService;
import com.example.demo.service.teacher.TeacherService;
import com.example.demo.util.Md5Helper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.lang.Class;
import java.util.List;

/**
 * Created by xiaoyaojiang on 2019/12/15.
 */
@Controller
public class teacherController {
    @Resource
    private TeacherService teacherService;
    @Resource
    private AdminCourseService adminCourseService;

    /**
     * 查询所有班级名称
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/addStudent1")
    public String findClassName(Model model) {
        //调用查询班级名称方法
        List<Class> className = adminCourseService.findClassName();
        //调用查询所有老师名字
        List<Teacher> tea_name = adminCourseService.findTea_name();
        //调用teacherService查询学生所学课程
        List<Course> course = teacherService.findCourse_CourseName();
        //把查询到的学生所学课程存进model中
        model.addAttribute("course", course);
        //把查到的值放进model中
        model.addAttribute("className", className);
        //把查到的值放进model中
        model.addAttribute("tea_name", tea_name);
        //返回的页面
        return "admin/addStudent";
    }

    /**
     * 添加学生用户
     *
     * @param student
     * @return
     */
    @RequestMapping(value = "/AddStudnet")

    public String AddStudnet(Student student, Model model) throws Exception {
        student.setDepartment("南昌德宏");
        //获取页面上的密码
        String password = student.getPassword();
        String random = Md5Helper.getRandom(16);
        //调用MD5加密传入密码加上随机数
        String md5Code = Md5Helper.getMD5Code(password + random);
        //把加密后的密码存进student
        student.setPassword(md5Code);
        student.setRandow(random);
        //调用AddStudent方法
        int i = teacherService.AddStudnet(student);
        //判断是否添加，添加成功跳转到学生信息页面，否则跳回本页面
        if (i > 0) {
            //返回的页面
            return "forward:/login";
        }
        return "addStudent1";

    }

    /**
     * //按老师身份来查询是否存在这个身份证
     *
     * @param card
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/CountPrd")
    public Object CountPrd(String card, Model model) {
        int i = teacherService.CountPrd(card);
        return i;
    }


    /**
     * //按学生身份来查询是否存在这个身份证
     *
     * @param
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/CountStudnePad")
    public Object CountStudnePad(String identity, Model model) {
        int kz = teacherService.CountStudnePad(identity);
        return kz;
    }


    /**
     * //按老师身份来查询是否存在这个账户
     *
     * @param
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/ThearchUserName")
    public Object ThearchUserName(String account, Model model) {
        int i = teacherService.ThearchUserName(account);
        return i;
    }

    /**
     * //按学生身份来查询是否存在这个账户
     *
     * @param
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/StudentUserName")
    public Object StudentUserName(String account, Model model) {
        int kz = teacherService.StudentUserName(account);
        return kz;
    }

    /**
     * //按老师身份证来查询是否存在这个账户
     *
     * @param
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/ThearchAccount")
    public Object ThearchAccount(String card, String account, Model model) {
        int kz = teacherService.ThearchAccount(card, account);
        return kz;
    }

    /**
     * //按学生身份证来查询是否存在这个账户
     *
     * @param
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/StudnetAccount")
    public Object StudnetAccount(String identity, String account, Model model) {
        int kz = teacherService.StudnetAccount(identity, account);
        return kz;
    }

    /**
     * 老师查询学生的信息
     */
    @RequestMapping(value = "/teaCherQuery")
    public String teaCherQuery(Model model, Integer id) {
        List<ScoreCustom> list = teacherService.teaCherQuery(id);
        //把查询到的信息放在model中
        model.addAttribute("list", list);
        model.addAttribute("Student", null);
        //返回的页面
        return "admin/stuScore";
    }

    /**
     * 老师按ID查询单个学生的信息
     */
    @RequestMapping(value = "/teCherStudnets")
    public String teCherStudnets(Integer stu_num, Model model) {
        ScoreCustom student = teacherService.teCherStudnets(stu_num);
        //把查询到的信息放在model中
        model.addAttribute("Student", student);
        model.addAttribute("list", null);

        //返回的页面
        return "admni/stuScore";
    }

    /**
     * 老师删除一个学生信息
     */
    @ResponseBody
    @RequestMapping(value = "/teChereliMinationStudent")
    public Object teChereliMinationStudent(Integer stu_num) {
        int i = teacherService.teChereliMinationStudent(stu_num);
        return i;
    }

    /**
     * 异步按学生学号查询是否存在此学生在学生表中（再进行添加）
     */

    @ResponseBody
    @RequestMapping(value = "/inFormation")
    public Object inFormation(Integer stu_num, Integer id, Model model) {
        List<AdditionScoreCustom> AdditionScoreCustom = teacherService.inFormation(stu_num, id);
        return AdditionScoreCustom;
    }

    /**
     * 老师添加学生成绩
     */
    @RequestMapping(value = "/AddStudentScore")
    public String AddStudentScore(Score score) {
        int i = teacherService.AddStudentScore(score);
        if (i > 0) {
            return "forward:/selectScore";
        }
        return "forward:teacher";

    }


    /**
     * 老师查询自己的一个个人信息()
     */
    @RequestMapping(value = "/teacherPersonal")
    public String teacherPersonal(Integer id, Model model) {
        Teacher teacher = teacherService.teacherPersonal(id);
        model.addAttribute("teacher", teacher);
        return "teacher/teacherInfo";

    }


    /**
     * 老师查询自己的一个个人信息放到修改页面去
     */
    @RequestMapping(value = "/teacherPersonalById")
    public String teacherPersonalById(Integer id, Model model) {
        Teacher teacher = teacherService.teacherPersonal(id);
        model.addAttribute("teacher", teacher);
        return "teacher/editTeacherInfo";

    }

    /**
     * 老师修改个人信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/updateTeacher")
    public String updateTeacher(Teacher teacher) {
        int i = teacherService.updateTeacher(teacher);
        if (i > 0) {
            return "forward:/teacherPersonal";
        } else {
            return "forward:/editTeacherInfo";
        }
    }

    /**
     * 老师查看课程信息
     */
    @RequestMapping(value = "/teacherCourse")
    public String teacherCourse(Integer id, Model model) {
        Course course = teacherService.teacherCourse(id);
        model.addAttribute("Course", course);
        return "teacher/courseAll";


    }


}
