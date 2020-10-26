package com.atguigu.pojo;

public class Person {
    private Integer id;
    private String name;
    private Integer age;
    private String phone;
    private Car car;

    public void init() {
        System.out.println("初始化方法");
    }
    public void destroy() {
        System.out.println("销毁方法");
    }

    public Person() {
    }

    public Person(Car car) {
        System.out.println("提车");
        this.car = car;
    }
    public Person(Integer id, String name, Integer age, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", car=" + car +
                '}';
    }
}