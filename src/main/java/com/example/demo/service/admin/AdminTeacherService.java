package com.example.demo.service.admin;

import com.example.demo.dao.admin.AdminTeacherMapper;
import com.example.demo.pojo.Teacher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaoyaojiang on 2019/12/20.
 */
@Service(value = "adminTeacherService")
public class AdminTeacherService {
    @Resource
    private AdminTeacherMapper adminTeacherMapper;

    /**
     * 添加老师账号
     *
     * @param teacher
     * @return
     */
    public int addTeacher_account(Teacher teacher) {
        int i = 0;
        try {
            i = adminTeacherMapper.addTeacher_account(teacher);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 查看老师信息
     *
     * @return
     */
    public List<Teacher> findTeacher() {
        List<Teacher> teachers = null;
        try {
            teachers = adminTeacherMapper.findTeacherGeRen();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teachers;
    }

    /**
     * 删除老师信息
     *
     * @param id
     * @return
     */
    public int deleteByStu_id_Teacher(int id) {
        int i = 0;
        try {
            i = adminTeacherMapper.deleteByStu_id_Teacher(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 查询要删除的老师是否代课
     *
     * @param id
     * @return
     */
    public int findTeacherByCount(int id) {
        int i = 0;
        try {
            i = adminTeacherMapper.findTeacherByCount(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
}
