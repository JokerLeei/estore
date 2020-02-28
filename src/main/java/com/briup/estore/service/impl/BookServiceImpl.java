package com.briup.estore.service.impl;

import com.briup.estore.bean.Book;
import com.briup.estore.dao.BookDao;
import com.briup.estore.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }


    @Override
    public List<Book> findAllBooks() throws Exception{
        List<Book> books = bookDao.findNewBooks();
        if(books.isEmpty()){
            throw new Exception("数据库无记录！");
        }else{
            return books;
        }
    }

    @Override
    public Book findBookById(Integer id) {
        return bookDao.findBookById(id);
    }

    @Override
    public List<Book> searchBooksByIndex(String index) {
        return bookDao.findBooksByIndex(index);
    }

}
