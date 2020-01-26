package com.example.demo.pojo;

/**
 * Created by xiaoyaojiang on 2019/12/19.
 * 班级类
 */
public class Class {
    private int id;//班级id
    private String ClassName;//班级名称
    private int tea_id;//所带老师id
    private int old_id;//年纪id
    private int course_id;//课程id

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public int getTea_id() {
        return tea_id;
    }

    public void setTea_id(int tea_id) {
        this.tea_id = tea_id;
    }

    public int getOld_id() {
        return old_id;
    }

    public void setOld_id(int old_id) {
        this.old_id = old_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }
}
