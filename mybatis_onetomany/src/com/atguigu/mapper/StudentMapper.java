package com.atguigu.mapper;

import com.atguigu.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    List<Student> queryStudentByClazzId();

    List<Student> queryStudentByCLazzIdAndLikeName(@Param("clazzId") Integer id,@Param("name") String name);
}
