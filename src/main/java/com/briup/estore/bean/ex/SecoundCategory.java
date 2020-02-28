package com.briup.estore.bean.ex;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Category;

import java.util.List;

public class SecoundCategory extends Category {
    // 该二级分类下所有图书
    private List<Book> bookList;
    // 该二级分类的所属的一级分类
    private Category rootCategory;


    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Category getRootCategory() {
        return rootCategory;
    }

    public void setRootCategory(Category rootCategory) {
        this.rootCategory = rootCategory;
    }

    @Override
    public String toString() {
        return "SecoundCategory{" +
                "bookList=" + bookList +
                ", rootCategory=" + rootCategory +
                '}';
    }
}
