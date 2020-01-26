package com.example.demo.service.admin;

import com.example.demo.dao.admin.AdminMapper;
import com.example.demo.pojo.Teacher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xiaoyaojiang on 2019/12/19.
 */
@Service(value = "adminService")
public class AdminService {
    @Resource
    private AdminMapper adminMapper;


}
