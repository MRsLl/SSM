package com.atguigu.mapper.test;

import com.atguigu.mapper.ClazzMapper;
import com.atguigu.pojo.Clazz;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClazzMapperTest {
    static SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
    }

    @Test
    public void queryClazzById() throws InterruptedException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
            Clazz clazz = mapper.queryClazzById(1);
            System.out.println(clazz);
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void queryClazzByIdInTwoSteps() throws InterruptedException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
            Clazz clazz = mapper.queryClazzByIdInTwoSteps(1);
            System.out.println(clazz.getName());
            Thread.sleep(6000);
            System.out.println(clazz);
        } finally {
            sqlSession.close();
        }
    }
}