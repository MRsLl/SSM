package com.atguigu.pojo;

public class Car {
    private String name;
    private String carNo;

    public Car(String name, String carNo) {
        this.name = name;
        this.carNo = carNo;
    }

    public Car() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", carNo='" + carNo + '\'' +
                '}';
    }
}