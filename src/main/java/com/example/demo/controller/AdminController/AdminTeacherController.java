package com.example.demo.controller.AdminController;

import com.example.demo.pojo.Teacher;
import com.example.demo.service.admin.AdminTeacherService;
import com.example.demo.util.Md5Helper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaoyaojiang on 2019/12/20.
 */
@Controller
public class AdminTeacherController {
    @Resource
    private AdminTeacherService adminTeacherService;

    /**
     * 管理员添加老师账号
     *
     * @param teacher
     * @return
     */
    @RequestMapping(value = "/addTeacher_account")
    public String addTeacher_account(Teacher teacher) {
        //获取页面上管理员输入的密码
        String password = teacher.getPassword();
        //生成随机数
        String random = Md5Helper.getRandom(16);
        //随机数加密码，进行MD5加盐
        String md5Code = Md5Helper.getMD5Code(password + random);
        //把随机数存进对象中
        teacher.setRandow(random);
        //把密码存进用户中
        teacher.setPassword(md5Code);
        //调用adminService添加老师方法：判断添加是否成功：是跳转页面 否返回本页面
        int i = adminTeacherService.addTeacher_account(teacher);
        if (i > 0) {
            return "admin/teacherAllInfo";
        }
        return "forward: addTeacher";
    }

    /**
     * 查询老师信息
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/findTeacherGeRen")
    public String findTeacher(Model model) {
        //调用teacherService查看老师信息
        List<Teacher> teacher = adminTeacherService.findTeacher();
        //把查到的集合放进model中
        model.addAttribute("teacher", teacher);
        //返回的页面
        return "admin/teacherAllInfo";
    }

    /**
     * 查询老师是否代课(暂无实现)
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/findTeacherByCount")
    @ResponseBody
    public Object findTeacherByCount(int id) {
        //调用adminTeacherService查询老师是否代课方法
        int teacherByCount = adminTeacherService.findTeacherByCount(id);
        return teacherByCount;
    }

    /**
     * 删除老师信息
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteByStu_id_Teacher")
    public Object deleteByStu_id_Teacher(int id) {
        //调用adminTeacherService删除方法
        int i = adminTeacherService.deleteByStu_id_Teacher(id);
        return i;
    }

}
