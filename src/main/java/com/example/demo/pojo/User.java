package com.example.demo.pojo;

/**
 * Created by xiaoyaojiang on 2019/12/12.
 * 用户登录
 */
public class User {
    private int user_id;//用户编号
    private String account;//用户账号
    private String user_name;//用户名
    private String password;//用户密码
    private String phone;//用户电话
    private int role_id;//用户角色
    private String randow;//MD5随机数
    private String role_name;//角色名称

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRandow() {
        return randow;
    }

    public void setRandow(String randow) {
        this.randow = randow;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
