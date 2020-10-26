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
import java.util.ArrayList;
import java.util.List;

public class UserMapperTest {
    static SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
    }

    @Test
    public void queryUserBySample(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            for (User user : mapper.queryUserBySample(new User(0, "z", 1))) {
                System.out.println(user);
            }

        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void queryUserBySampleChoose(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            for (User user : mapper.queryUserBySampleChoose(new User(0, "z", 0))) {
                System.out.println(user);
            }

        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.updateUser(new User(4,null,1));
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void queryUsersByIds(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);

            for (User user : mapper.queryUserByIds(list)) {
                System.out.println(user);
            }
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void insertUsers(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> list = new ArrayList<>();
            list.add(new User(0,"jack",1));
            list.add(new User(0,"Peter",0));

            mapper.insertUsers(list);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
}
