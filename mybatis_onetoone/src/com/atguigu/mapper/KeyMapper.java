package com.atguigu.mapper;

import com.atguigu.pojo.Key;

public interface KeyMapper {

    Key queryKeyById(Integer id);

    Key queryKeyByIdForSimple(Integer id);
}
