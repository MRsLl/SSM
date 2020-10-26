package com.atguigu.pojo;

public class Car {
    private String name;
    private String pageNo;

    public Car() {
    }

    public Car(String name, String pageNo) {
        this.name = name;
        this.pageNo = pageNo;
    }

    public static String staticFun(String str) {
        return str;
    }
    public static String noStaticFun(String str) {
        return str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", pageNo='" + pageNo + '\'' +
                '}';
    }
}
