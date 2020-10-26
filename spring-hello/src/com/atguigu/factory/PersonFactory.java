package com.atguigu.factory;

import com.atguigu.pojo.Person;

public class PersonFactory {
    public static Person create() {
        return new Person(1,"张三",18,"001");
    }

    public Person create2() {
        return new Person(100,"工厂实例方法",18,"110");
    }
}
