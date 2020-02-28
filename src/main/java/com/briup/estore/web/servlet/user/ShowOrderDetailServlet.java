package com.briup.estore.web.servlet.user;

import com.briup.estore.bean.ex.OrderLineEX;
import com.briup.estore.dao.impl.OrderDaoImpl;
import com.briup.estore.service.OrderService;
import com.briup.estore.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "ShowOrderDetailServlet", urlPatterns = "/user/showOrderDetailServlet")
public class ShowOrderDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*orderFormId*/
        int orderFormId = Integer.parseInt(request.getParameter("orderFormId"));

        OrderService orderService=new OrderServiceImpl(new OrderDaoImpl());
        List<OrderLineEX> orderLines = orderService.findOrderLinesByOrderFormId(orderFormId);
        request.setAttribute("orderLines",orderLines);

        // 获取合计金额
        double total=0;
        for (OrderLineEX orderLine : orderLines) {
            total += orderLine.getCost();
        }
        request.setAttribute("total",total);

        request.getRequestDispatcher("/user/orderdetail.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
