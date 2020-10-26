package com.atguigu.dao.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int saveBook(Book book) {
        String sql = "insert into t_book(`name`,`author`,`price`,`sales`,`stock`) values(?,?,?,?,?)";
        return jdbcTemplate.update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock());
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set `name` = ? ,`author` = ? ,`price` = ? ,`sales` = ? ,`stock` = ? where id = ?";
        return jdbcTemplate.update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getId());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock` from t_book where id = ?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Book>(Book.class),id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock` from t_book";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Book>(Book.class));
    }
}
