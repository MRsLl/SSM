package com.atguigu.test;

import com.atguigu.mapper.KeyMapper;
import com.atguigu.mapper.LockMapper;
import com.atguigu.pojo.Key;
import com.atguigu.pojo.Lock;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class KeyMapperTest {
    static SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = (SqlSessionFactory) new SqlSessionFactoryBuilder().build(resourceAsStream);
    }
    @Test
    public void queryKeyById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            KeyMapper mapper = sqlSession.getMapper(KeyMapper.class);
            Key key = mapper.queryKeyById(1);
            System.out.println(key);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void queryLockById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            LockMapper mapper = sqlSession.getMapper(LockMapper.class);
            Lock lock = mapper.queryLockById(1);
            System.out.println(lock);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void queryLockByIdForSimple() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            KeyMapper keyMapper = sqlSession.getMapper(KeyMapper.class);
            Key key = keyMapper.queryKeyByIdForSimple(1);

            System.out.println(key.getId());

            Thread.sleep(6000);
            System.out.println(key.getLock());
        } finally {
            sqlSession.close();
        }
    }
}
