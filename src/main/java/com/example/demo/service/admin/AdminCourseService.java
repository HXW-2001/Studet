package com.example.demo.service.admin;

import com.example.demo.dao.admin.AdminCourseMapper;
import com.example.demo.pojo.Course;
import com.example.demo.pojo.Teacher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaoyaojiang on 2019/12/19.
 */
@Service(value = "adminCourseService")
public class AdminCourseService {

    @Resource
    private AdminCourseMapper adminCourseMapper;

    /**
     * 查询班级名称
     *
     * @return
     */
    public List<Class> findClassName() {
        List<Class> string = null;
        try {
            string = adminCourseMapper.findClassName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return string;
    }

    /**
     * 查询所有老师名称
     *
     * @return
     */
    public List<Teacher> findTea_name() {
        List<Teacher> string = null;
        try {
            string = adminCourseMapper.findTea_name();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return string;
    }

    /**
     * 调用courseMapper中的添加课程信息
     *
     * @param course
     * @return
     */
    public int courseAdd(Course course) {
        int i = 0;
        try {
            i = adminCourseMapper.courseAdd(course);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 调用courseMapper查询课程信息方法
     *
     * @return
     */
    public List<Course> findCourse() {
        List<Course> list = null;
        try {
            list = adminCourseMapper.findCourse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 根据course_id查询代课信息
     *
     * @param course_id
     * @return
     */
    public Course findCourseByCourse_id(int course_id) {
        Course course = null;
        try {
            course = adminCourseMapper.findCourseByCourse_id(course_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return course;
    }

    /**
     * 修改课程信息
     *
     * @param course
     * @return
     */
    public int updateCourse(Course course) {
        int i = 0;
        try {
            i = adminCourseMapper.updateCourse(course);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
}
