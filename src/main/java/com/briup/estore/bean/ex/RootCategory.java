package com.briup.estore.bean.ex;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Category;

import java.util.List;

public class RootCategory extends Category {

    // 该(一级)分类的所有子分类
    private List<Category> childCategories;
    // 该(一级)分类下的所有图书
    private List<Book> bookList;

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Category> getChildCategories() {
        return childCategories;
    }

    public void setChildCategories(List<Category> childCategories) {
        this.childCategories = childCategories;
    }

    @Override
    public String toString() {
        return "RootCategory{" +
                "childCategories=" + childCategories +
                ", bookList=" + bookList +
                '}';
    }
}
