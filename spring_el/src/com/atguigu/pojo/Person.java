package com.atguigu.pojo;

public class Person {
    private Integer id;
    private String name;
    private String phone;
    private double salary;
    private Car car;

    public Person() {
    }

    public Person(Integer id, String name, String phone, double salary, Car car) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.salary = salary;
        this.car = car;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", car=" + car +
                '}';
    }
}