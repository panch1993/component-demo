package com.pans.m.sub09;

/**
 * Create by panchenhuan on 2021/8/23
 * walkwindc8@foxmail.com
 * Description:
 */
public class Student {
    private String name = "default";

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
