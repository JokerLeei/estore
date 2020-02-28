package com.briup.estore.service;

import com.briup.estore.bean.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBooks() throws Exception;

    Book findBookById(Integer id);

    List<Book> searchBooksByIndex(String index);
}
