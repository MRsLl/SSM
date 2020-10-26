package com.atguigu.pojo;

import com.atguigu.utils.LogUtils;

public class Caculator implements Caculate{
    public int add(int num1, int num2) {

            int result = num1 + num2;
            return result;
    }

    public int add(int num1, int num2, int num3) {

            int result = num1 + num2 + num3;
            return result;
    }

    public int div(int num1, int num2) {

            int result = num1 / num2;
            return result;

    }

}
