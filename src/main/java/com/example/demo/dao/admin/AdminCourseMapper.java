package com.example.demo.dao.admin;

import com.example.demo.pojo.Course;
import com.example.demo.pojo.Teacher;

import java.util.List;

/**
 * Created by xiaoyaojiang on 2019/12/19.
 */
public interface AdminCourseMapper {


    /**
     * 查询班级名称
     *
     * @return
     * @throws Exception
     */
    List<Class> findClassName() throws Exception;

    /**
     * 查询班级名称
     *
     * @return
     * @throws Exception
     */
    List<Teacher> findTea_name() throws Exception;

    /**
     * 添加课程信息
     *
     * @param course
     * @return
     * @throws Exception
     */
    int courseAdd(Course course) throws Exception;

    /**
     * 查看课程信息
     *
     * @return
     * @throws Exception
     */
    List<Course> findCourse() throws Exception;

    /**
     * 根据course_id查询代课信息
     *
     * @param course_id
     * @return
     * @throws Exception
     */
    Course findCourseByCourse_id(int course_id) throws Exception;


    /**
     * 修改科目信息
     *
     * @param course
     * @return
     * @throws Exception
     */
    int updateCourse(Course course) throws Exception;
}
