package com.atguigu.pojo;

public class Car {
    private  String type;
    private  String carNo;

    public Car() {
    }

    public Car(String type, String carNo) {
        this.type = type;
        this.carNo = carNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
                "type='" + type + '\'' +
                ", carNo='" + carNo + '\'' +
                '}';
    }
}
