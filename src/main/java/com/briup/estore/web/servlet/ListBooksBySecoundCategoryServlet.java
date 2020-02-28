package com.briup.estore.web.servlet;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Category;
import com.briup.estore.bean.ex.SecoundCategory;
import com.briup.estore.dao.impl.BookDaoImpl;
import com.briup.estore.dao.impl.CategoryDaoImpl;
import com.briup.estore.service.BookService;
import com.briup.estore.service.CategoryService;
import com.briup.estore.service.impl.BookServiceImpl;
import com.briup.estore.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ListBooksBySecoundCategoryServlet", urlPatterns = "/listBooksBySecoundCategoryServlet")
public class ListBooksBySecoundCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取参数
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

        CategoryService categoryService = new CategoryServiceImpl(new CategoryDaoImpl());
        SecoundCategory secoundCategory = categoryService.findSecoundCategoryWithBooksByCategoryId(categoryId);

        System.out.println("secoundCategory:");
        System.out.println(secoundCategory);

        request.setAttribute("rootCategory", secoundCategory.getRootCategory());
        request.setAttribute("secoundCategory",secoundCategory);
        request.setAttribute("bookList", secoundCategory.getBookList());
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
