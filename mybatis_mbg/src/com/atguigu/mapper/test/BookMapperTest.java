package com.atguigu.mapper.test;

import com.atguigu.mapper.BookMapper;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.BookExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BookMapperTest {

    static SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
    }

    @Test
    public void countByExample() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);
            BookExample bookExample = new BookExample();
            BookExample.Criteria criteria = bookExample.createCriteria();
            criteria.andAuthorEqualTo("国哥");


            BookExample.Criteria or = bookExample.or();

            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= 5; i++) {
                list.add(i);
            }
            or.andIdNotIn(list);

            int i = mapper.countByExample(bookExample);
            System.out.println(i);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void deleteByExample() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);

            BookExample bookExample = new BookExample();
            BookExample.Criteria criteria = bookExample.createCriteria();
            criteria.andNameLike("%数%");
            BookExample.Criteria or = bookExample.or();
            or.andSalesGreaterThanOrEqualTo(1000);

            mapper.deleteByExample(bookExample);

            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void insertSelective() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);

            mapper.insertSelective(new Book(null,null,null,new BigDecimal("12"),10,1000));

            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 根据条件进行更新，忽略为空的字段
     */
    @Test
    public void updateByExampleSelective() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            BookMapper mapper = sqlSession.getMapper(BookMapper.class);

            BookExample bookExample = new BookExample();
            BookExample.Criteria criteria = bookExample.createCriteria();
            criteria.andStockGreaterThan(500);
            BookExample.Criteria or = bookExample.or();
            or.andAuthorEqualTo("龙伍");

            mapper.updateByExampleSelective(new Book(null,"变形记","卡夫卡",null,null,10),bookExample);

            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
}
