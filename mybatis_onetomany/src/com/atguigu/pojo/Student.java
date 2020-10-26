package com.atguigu.pojo;

public class Student {
    private Integer id;
    private String name;
    private Integer clazzId;

    public Student() {
    }

    public Student(Integer id, String name, Integer clazzId) {
        this.id = id;
        this.name = name;
        this.clazzId = clazzId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClazzId() {
        return clazzId;
    }

    public void setClazzId(Integer clazzId) {
        this.clazzId = clazzId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", clazzId=" + clazzId +
                '}';
    }
}
