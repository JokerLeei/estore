package com.briup.estore.web.servlet.user;

import com.briup.estore.bean.ex.ShopCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteOrderLineInShopCartByIdServlet", urlPatterns = "/user/deleteOrderLineInShopCartByIdServlet")
public class DeleteOrderLineInShopCartByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ShopCart shopCart = (ShopCart) request.getSession().getAttribute("shopCart");

        shopCart.deleteById(id);
        request.getRequestDispatcher("/user/shopCart.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
