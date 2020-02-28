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
import java.text.SimpleDateFormat;

@WebServlet(name = "FindBookByIdServlet", urlPatterns = "/findBookByIdServlet")
public class FindBookByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookService bookService=new BookServiceImpl(new BookDaoImpl());

        Integer id=Integer.parseInt(request.getParameter("id"));

        Book book = bookService.findBookById(id);
        request.getSession().setAttribute("book",book);

        // 转换日期格式
        SimpleDateFormat sdf=new SimpleDateFormat("YYYY-mm-DD");
        String pubdate = sdf.format(book.getPubdate());
        request.setAttribute("pubdate",pubdate);

        request.getRequestDispatcher("/viewBook.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
