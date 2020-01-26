package com.example.demo.dao.admin;

import com.example.demo.pojo.Teacher;

import java.util.List;

/**
 * Created by xiaoyaojiang on 2019/12/20.
 */
public interface AdminTeacherMapper {

    /**
     * 添加老师账号
     *
     * @param teacher
     * @return
     */
    int addTeacher_account(Teacher teacher) throws Exception;

    /**
     * 查询老师信息
     *
     * @return
     * @throws Exception
     */
    List<Teacher> findTeacherGeRen() throws Exception;

    /**
     * 查询要删除的老师是否代课
     *
     * @param id
     * @return
     */
    int findTeacherByCount(int id) throws Exception;

    /**
     * 删除老师信息
     *
     * @param stu_id
     * @return
     * @throws Exception
     */
    int deleteByStu_id_Teacher(int stu_id) throws Exception;
}
