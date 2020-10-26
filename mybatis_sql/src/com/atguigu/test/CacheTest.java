package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;


public class CacheTest {
    static SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
    }

    @Test
    public void queryUserById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            System.out.println(mapper.queryUserById(1));
            System.out.println(mapper.queryUserById(1));
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void queryOne() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            System.out.println(mapper.queryUserById(1));
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void firstCacheFail1() {
        queryOne();
        queryOne();
    }

    @Test
    public void firstCacheFail2() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            System.out.println(mapper.queryUserById(1));
            System.out.println(mapper.queryUserById(2));
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void firstCacheFail3() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            System.out.println(mapper.queryUserById(1));
            sqlSession.clearCache();
            System.out.println(mapper.queryUserById(1));
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void firstCacheFail4() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            System.out.println(mapper.queryUserById(1));
            mapper.insertUser(new User(0,"Green",1));
            System.out.println(mapper.queryUserById(1));
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void secondCache() {
        queryOne();
        queryOne();
    }

}
