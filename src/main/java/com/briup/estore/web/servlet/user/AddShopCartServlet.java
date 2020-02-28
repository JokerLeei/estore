package com.briup.estore.web.servlet.user;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.ex.ShopCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddShopCartServlet", urlPatterns = "/user/addShopCartServlet")
public class AddShopCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取加入购物车 参数(数量，书对象)
        int num = Integer.parseInt(request.getParameter("num"));
        Book book = (Book) request.getSession().getAttribute("book");
        System.out.println(num);
        System.out.println(book);

        ShopCart shopCart = (ShopCart) request.getSession().getAttribute("shopCart");
        if (shopCart == null) {
            ShopCart sc = new ShopCart();
            sc.addBook(book, num);
            request.getSession().setAttribute("shopCart", sc);

            System.out.println(sc);
        } else {
            shopCart.addBook(book, num);
            request.getSession().setAttribute("shopCart", shopCart);

            System.out.println(shopCart);
        }

        request.getRequestDispatcher("/user/shopCart.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
