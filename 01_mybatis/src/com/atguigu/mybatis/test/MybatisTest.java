package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {
    static SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        // 由mybatis-config.xml配置文件,先构建SqlSessionFactory对象实例
        //读取mybatis-config.xml配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    @Test
    public void queryById() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //获取指定类型的Mapper接口实现类
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.queryById(1);
            System.out.println(user);
        } finally {
            //关闭sqlSession 对象
            sqlSession.close();
        }
    }

    @Test
    public void queryUsers() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //获取指定类型的Mapper接口实现类
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = mapper.queryUsers();
            for (User user : users) {
                System.out.println(user);
            }
        } finally {
            //关闭sqlSession 对象
            sqlSession.close();
        }
    }

    @Test
    public void saveUser() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //获取指定类型的Mapper接口实现类
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = new User(null, "wangwu", 0);
            int count = mapper.saveUser(user);
            System.out.println("影响的行数为==>" + count);
            System.out.println(user);
            sqlSession.commit();
        } finally {
            //关闭sqlSession 对象
            sqlSession.close();
        }
    }
    @Test
    public void updateUser() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //获取指定类型的Mapper接口实现类
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int count = mapper.updateUser(new User(2, "lisi", 1));
            System.out.println("影响的行数为==>" + count);
            sqlSession.commit();
        } finally {
            //关闭sqlSession 对象
            sqlSession.close();
        }
    }

    @Test
    public void deleteUserById() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //获取指定类型的Mapper接口实现类
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int count = mapper.deleteUserById(2);
            System.out.println("影响的行数为==>" + count);
            sqlSession.commit();
        } finally {
            //关闭sqlSession 对象
            sqlSession.close();
        }
    }

    @Test
    public void queryUserForMap() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //获取指定类型的Mapper接口实现类
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Map<String,Object> paramMap = new HashMap<>();
            paramMap.put("name","wzg168");
            paramMap.put("sex", 1);

            for (User user : mapper.queryUsersForMap(paramMap)) {
                System.out.println(user);
            }

            sqlSession.commit();
        } finally {
            //关闭sqlSession 对象
            sqlSession.close();
        }
    }
}
