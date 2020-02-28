package com.briup.estore.bean.ex;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.OrderLine;

public class OrderLineEX extends OrderLine {
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "OrderLineEX{" +
                "book=" + book +
                '}';
    }
}
