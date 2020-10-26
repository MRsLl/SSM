package com.atguigu.pojo;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Person {
    private Integer id;
    private String name;
    private Integer age;
    private String phone;
    private Car car;
    private List<String> list;
    private Map<String,Object> map;
    private Properties properties;


    public Person() {
        System.out.println("Person 的无参构造");
    }

    public Person(Integer id, String name, Integer age, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        System.out.println("Person 的有参构造");
    }

    public Person(Integer id, String name, String phone,Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        System.out.println("Person 的有参构造");
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
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

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", car=" + car +
                ", list=" + list +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }
}
