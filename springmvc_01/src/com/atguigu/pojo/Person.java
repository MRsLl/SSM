package com.atguigu.pojo;

public class Person {
    private Integer id;
    private Integer age;
    private String name;
    private String phone;
    private Car car;

    public Person() {
    }

    public Person(Integer id, Integer age, String name, String phone, Car car) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.phone = phone;
        this.car = car;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", age=" + age +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", car=" + car +
                '}';
    }
}