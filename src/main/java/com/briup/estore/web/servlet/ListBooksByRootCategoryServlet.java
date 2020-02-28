package com.briup.estore.web.servlet;

import com.briup.estore.bean.ex.RootCategory;
import com.briup.estore.dao.impl.CategoryDaoImpl;
import com.briup.estore.service.CategoryService;
import com.briup.estore.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ListBooksByRootCategoryServlet", urlPatterns = "/listBooksByRootCategoryServlet")
public class ListBooksByRootCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

        CategoryService categoryService = new CategoryServiceImpl(new CategoryDaoImpl());
        RootCategory rootCategory = categoryService.findRootCategoryWithBooksByCategoryId(categoryId);

        System.out.println("rootCategory:");
        System.out.println(rootCategory);

        request.setAttribute("rootCategory", rootCategory);
        request.setAttribute("bookList", rootCategory.getBookList());
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
