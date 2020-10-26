package com.atguigu.mapper;

import com.atguigu.pojo.Clazz;

public interface ClazzMapper {

    Clazz queryClazzById(Integer id);

    Clazz queryClazzByIdInTwoSteps(Integer id);

}
