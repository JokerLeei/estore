package com.briup.estore.dao.impl;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.BookExample;
import com.briup.estore.bean.Category;
import com.briup.estore.bean.CategoryExample;
import com.briup.estore.dao.BookDao;
import com.briup.estore.mapper.BookMapper;
import com.briup.estore.mapper.CategoryMapper;
import com.briup.util.MybatisSqlSessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BookDaoImpl implements BookDao {
    @Override
    public List<Book> findNewBooks() {
        BookMapper mapper = MybatisSqlSessionFactory.getMapper(BookMapper.class);
        long count = mapper.countByExample(null);
        if(count<=6){
            return mapper.selectByExample(null);
        }else{
            BookExample example = new BookExample();
            BookExample.Criteria criteria = example.createCriteria();

            criteria.andIdGreaterThan((int)(count-6));
            return mapper.selectByExample(example);
        }
    }

    @Override
    public Book findBookById(Integer id) {
        BookMapper mapper = MybatisSqlSessionFactory.getMapper(BookMapper.class);
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Book> findBooksByIndex(String index) {
        BookMapper mapper = MybatisSqlSessionFactory.getMapper(BookMapper.class);
        if(index==null){
            return mapper.selectByExample(null);
        }else{
            // 模糊查询
            BookExample example = new BookExample();
            BookExample.Criteria criteria = example.createCriteria();
            criteria.andNameLike("%"+index.trim()+"%");

            return mapper.selectByExample(example);
        }
    }

}
