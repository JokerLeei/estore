package com.briup.estore.web.servlet.user;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.ex.OrderFormEX;
import com.briup.estore.dao.impl.OrderDaoImpl;
import com.briup.estore.service.OrderService;
import com.briup.estore.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListOrdersServlet", urlPatterns = "/user/listOrdersServlet")
public class ListOrdersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        Integer customerId = customer.getId();

        OrderService orderService = new OrderServiceImpl(new OrderDaoImpl());
        List<OrderFormEX> orders = orderService.findOrdersAllPropertiesByCustomerId(customerId);
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("/user/orderlist.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
