package com.briup.estore.web.servlet;

import com.briup.estore.bean.Book;
import com.briup.estore.dao.impl.BookDaoImpl;
import com.briup.estore.service.BookService;
import com.briup.estore.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet", urlPatterns = "/searchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 索取参数
        request.setCharacterEncoding("utf-8");
        String index = request.getParameter("index");
        System.out.println(index);
        // 搜索
        BookService bookService=new BookServiceImpl(new BookDaoImpl());
        List<Book> bookList = bookService.searchBooksByIndex(index);

        System.out.println(bookList);
        request.setAttribute("bookList",bookList);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
