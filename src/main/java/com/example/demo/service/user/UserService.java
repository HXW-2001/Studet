package com.example.demo.service.user;

import com.example.demo.dao.user.UserMapper;
import com.example.demo.pojo.Student;
import com.example.demo.pojo.Teacher;
import com.example.demo.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xiaoyaojiang on 2019/12/12.
 */
@Service(value = "userService")
public class UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    public int Login(User user) {
        int i = 0;
        try {
            i = userMapper.login(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 查询用户随机数
     *
     * @param account
     * @return
     */
    public User LoginRandow(String account) {
        User user = null;
        try {
            user = userMapper.LoginRandow(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 老师账户修改账户密码
     */

    public int updateTherachAccount(Teacher teacher) {
        int i = 0;
        try {
            i = userMapper.updateTherachAccount(teacher);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;

    }

    /**
     * 学生账户修改账户密码
     */

    public int updateStundentAccount(Student student) {
        int i = 0;
        try {
            i = userMapper.updateStundentAccount(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;

    }
}








