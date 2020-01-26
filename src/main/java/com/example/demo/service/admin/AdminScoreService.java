package com.example.demo.service.admin;

import com.example.demo.dao.admin.AdminScoreMapper;
import com.example.demo.pojo.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiaoyaojiang on 2019/12/21.
 */
@Service(value = "adminScoreService")
public class AdminScoreService {

    @Resource
    private AdminScoreMapper adminScoreMapper;

    /**
     * 查询学生成绩以及班级
     *
     * @return
     */
    public List<Student> findClass_ClassName() {
        List<Student> list = null;
        try {
            list = adminScoreMapper.findClass_ClassName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 查询学生个人排名，以及班级平均分，班级人数
     *
     * @param stu_num
     * @return
     */
    public Student findScoreByStu_num(int stu_num) {
        Student list = null;
        try {
            list = adminScoreMapper.findScoreByStu_num1(stu_num);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
