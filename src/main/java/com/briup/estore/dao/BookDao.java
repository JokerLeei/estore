package com.briup.estore.dao;

import com.briup.estore.bean.Book;

import java.util.List;

public interface BookDao {
    // 查找最新6本书
    List<Book> findNewBooks();
    // 根据id查出对应图书
    Book findBookById(Integer id);
    // 根据书名模糊查询图书
    List<Book> findBooksByIndex(String index);
}
