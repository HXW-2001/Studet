package com.example.demo.controller.StudentController;

import com.example.demo.pojo.ScoreCustom;
import com.example.demo.pojo.Student;
import com.example.demo.pojo.Teacher;
import com.example.demo.service.admin.AdminCourseService;
import com.example.demo.service.student.StudnetService;
import com.example.demo.util.Md5Helper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaoyaojiang on 2019/12/15.
 */
@Controller
public class StudentController {
    @Resource
    private StudnetService studnetService;

    @Resource
    private AdminCourseService adminCourseService;

    /**
     * 调用studentService按id查询学生方法
     *
     * @param model
     * @param stu_id
     * @return
     */
    @RequestMapping(value = "/findStudentByid")
    public String findStudentByid(Model model, Integer stu_id) {
        //调用方法，把前台获取的id放进去进行查询
        Student studentByid = studnetService.findStudentByid(stu_id);
        //把查到的数据放在model中
        model.addAttribute("studentByid", studentByid);
        //返回学生补充信息页面
        return "forward:/studentInfo1";
    }

    /**
     * 完善学生个人信息
     *
     * @param student
     * @param model
     * @return
     */
    @RequestMapping(value = "/updateStudent")
    public String updateStudent(Student student, Model model) {
        //调用studnetService完善学生信息方法
        int i = studnetService.updateStudent(student);
        //判断是否完善成功：成功跳转到查看学生信息页面，否则停留在补充页面
        if (i > 0) {
            //完善成功把值存在model中
            model.addAttribute("student", student);
            //返回的页面
            return "forward:/studentOne";
        }
        //返回的页面
        return "studentInfo1";
    }

    /**
     * 查看学生个人信息
     *
     * @return
     */
    @RequestMapping(value = "/studentOne")
    public String studentOne(Model model, Integer stu_id) {
        //调用studnetService查询学生个人信息
        Student student = studnetService.findStudent(stu_id);
        //把对象放在Model中
        model.addAttribute("student", student);
        //返回的页面
        return "student/studentOne";
    }

    /**
     * 修改页面显示用户资料
     * 调用studentService按id查询学生方法
     *
     * @param model
     * @param stu_id
     * @return
     */
    @RequestMapping(value = "/findStudentByid1")
    public String findStudentByid1(Model model, Integer stu_id) {
        //调用方法，把前台获取的id放进去进行查询
        Student studentByid = studnetService.findStudentByid(stu_id);
        //把查到的数据放在model中
        model.addAttribute("studentByid", studentByid);
        //返回学生补充信息页面
        return "forward:/editStudentInfo";
    }

    /**
     * 调用studnetService的学生修改个人资料方法
     *
     * @param student
     * @param model
     * @return
     */
    @RequestMapping(value = "/updateFindStudent")
    public String updateFindStudent(Student student, Model model) {
        //把页面用户输入的值放入方法中
        int i = studnetService.updateFindStudent(student);
        //判断学生个人资料是否修改成功：成功跳转到查看个人资料页面，否则返回本页面
        if (i > 0) {
            //把数据放在model中
            model.addAttribute("student", student);
            return "forward:/studentOne";
        }
        //返回本页面
        return "findStudentByid1";
    }

    /**
     * 查询学生成绩信息
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/selectScore")
    public String selectScore(Model model) {
        //调用studnetService查询学生成绩信息方法
        List<ScoreCustom> score = studnetService.findScore();
        //调用查询班级名称方法
        List<Class> className = adminCourseService.findClassName();
        //调用查询所有老师名字
        List<Teacher> tea_name = adminCourseService.findTea_name();
        //把查到的值放进model中
        model.addAttribute("className", className);
        //把查到的值放进model中
        model.addAttribute("tea_name", tea_name);
        //把查询到的信息放在model中
        model.addAttribute("score", score);
        //返回的页面
        return "student/selectScore";
    }

    /**
     * 修改密码
     *
     * @return
     */
    @RequestMapping(value = "/updatePwd")
    public String updatePwd(Student student, Integer stu_id) {
        //拿到页面用户输入的密码
        String password = student.getPassword();
        //根据学生id查询到的随机数
        Student s = studnetService.UpdFindRandow(stu_id);
        //密码加上随机数，对密码加盐
        String md5Code = Md5Helper.getMD5Code(password + s.getRandow());
        //把加盐后的密码放进对象中
        student.setPassword(md5Code);
        //把修改后的随机数放进对象中
        student.setRandow(s.getRandow());
        //调用studnetService修改学生信息密码
        int i = studnetService.updatePwd(student);
        //判断是否修改成功：修改成功跳转到登录页，否则返回本页面
        if (i > 0) {
            return "/login";
        }
        //返回的页面
        return "student/updatePwd";
    }

    /**
     * 修改学生头像
     *
     * @param student
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateHead")
    public Object updateHead(Student student) {
        int i = studnetService.updateHead(student);
        return i;
    }

    /**
     * 调用studentService多条件查询学生成绩
     *
     * @param student
     * @return
     */
    @RequestMapping(value = "/multitermFindScore")
    public String multitermFindScore(Student student, Model model) {
        //studnetService调用多条件查询学生成绩
        List<ScoreCustom> score = studnetService.multitermFindScore(student);
        //把查到的值存进model中
        model.addAttribute("score", score);
        //返回的页面
        return "student/selectScore";
    }

}
