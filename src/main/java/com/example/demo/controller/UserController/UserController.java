package com.example.demo.controller.UserController;

import com.example.demo.pojo.Student;
import com.example.demo.pojo.Teacher;
import com.example.demo.pojo.User;
import com.example.demo.service.student.StudnetService;
import com.example.demo.service.teacher.TeacherService;
import com.example.demo.service.user.UserService;
import com.example.demo.util.Md5Helper;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by xiaoyaojiang on 2019/12/12.
 * 用户模块Controller
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private StudnetService studnetService;

    @Resource
    private TeacherService teacherService;

    /**
     * 学生登录
     *
     * @param session
     * @param user
     * @param student
     * @param
     * @return
     */
    @RequestMapping(value = "/userlogin")
    public String Login(HttpSession session, User user, Student student, Teacher teacher, String checkCode, HttpServletRequest request) {
        //获取验证码对象
        Object cko = session.getAttribute("simpleCaptcha");
        if (cko == null) {
            request.setAttribute("errorMsg", "输入验证码有误!");
            return "login/login";
        }
        String captcha = cko.toString();
        if (StringUtils.isEmpty(checkCode.toUpperCase()) || captcha == null || !(checkCode.equalsIgnoreCase(captcha))) {
            request.setAttribute("errorMsg", "输入验证码有误!");
            return "login/login";
        } else {
            //拿到页面用户输入的密码
            String password = user.getPassword();
            //判断用户登录角色
            if (user.getRole_id() == 0) {
                //调用查询随机数方法
                Student student1 = studnetService.LoginRandow(student.getAccount());
                //调用Md5加密并把密码和随机数放里面
                String md5Code = Md5Helper.getMD5Code(password + student1.getRandow());
                //把加密好的密码放进user里
                student.setPassword(md5Code);
                //调用登录用户信息
                int i = studnetService.StudentLogin(student);
                //判断学生是否登录成功：成功跳转到学生主页，否则返回登录页
                if (i > 0) {
                    session.setAttribute("student1", student1);
                    return "forward:/student";
                }
            } else if (user.getRole_id() == 1) {  //判断用户登录角色
                Teacher teacher1 = teacherService.teacherRandow(teacher.getAccount());
                //调用Md5加密并把密码和随机数放里面
                String md5Code = Md5Helper.getMD5Code(password + teacher1.getRandow());
                //把加密好的密码放进teacher里
                teacher.setPassword(md5Code);
                int teachers = teacherService.teacherLogin(teacher);
                if (teachers > 0) {
                    //登录用户信息
                    session.setAttribute("teacher", teacher1);
                    teacher1.getId();
                    return "forward:/teacher";
                }
            } else if (user.getRole_id() == 2) { //判断用户登录角色
                //调用查询随机数方法
                User user2 = userService.LoginRandow(user.getAccount());
                //调用Md5加密并把密码和随机数放里面
                String md5Code = Md5Helper.getMD5Code(password + user2.getRandow());
                //把加密好的密码放进user里
                user.setPassword(md5Code);
                //调用userService方法
                int login = userService.Login(user);
                //登录用户信息
                session.setAttribute("login", login);
                return "forward:/admin";
            }
        }
        //登录不成功返回login页面
        return "login/login";
    }


    /**
     * 老师修改账户密码
     *
     * @param teacher
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/UpdatTheacherAccount")
    public Object UpdatTheacherAccount(Teacher teacher) {
        int i = userService.updateTherachAccount(teacher);
        return i;
    }


    /**
     * 学生修改账户密码
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateStundentAccount")
    public Object updateStundentAccount(Student student) {
        int i = userService.updateStundentAccount(student);
        return i;
    }


}
