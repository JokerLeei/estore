package com.briup.estore.web.servlet.user;

import com.briup.estore.dao.impl.OrderDaoImpl;
import com.briup.estore.service.OrderService;
import com.briup.estore.service.impl.OrderServiceImpl;
import org.omg.CORBA.ORB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteOrderServlet", urlPatterns = "/user/deleteOrderServlet")
public class DeleteOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderFormId = Integer.parseInt(request.getParameter("id"));
        OrderService orderService = new OrderServiceImpl(new OrderDaoImpl());
        orderService.deleteOrderFormAndOrderLineByOrderFormId(orderFormId);

        request.getRequestDispatcher("listOrdersServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
