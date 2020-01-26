package com.example.demo.dao.user;


import com.example.demo.pojo.Student;
import com.example.demo.pojo.Teacher;
import com.example.demo.pojo.User;

/**
 * Created by xiaoyaojiang on 2019/12/12.
 */
public interface UserMapper {
    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    int login(User user) throws Exception;

    /**
     * 查询随机数
     *
     * @param account
     * @return
     */
    User LoginRandow(String account) throws Exception;

    /**
     * 注册用户信息
     *
     * @param user
     * @return
     */
    int userAdd(User user);

    /**
     * 老师账户修改账户密码
     */
    int updateTherachAccount(Teacher teacher);

    /**
     * 学生账户修改账户密码
     */
    int updateStundentAccount(Student student);
}
