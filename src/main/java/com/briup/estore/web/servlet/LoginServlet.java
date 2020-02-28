package com.briup.estore.web.servlet;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.ShopAddress;
import com.briup.estore.bean.ex.OrderFormEX;
import com.briup.estore.dao.impl.CustomerDaoImpl;
import com.briup.estore.dao.impl.OrderDaoImpl;
import com.briup.estore.dao.impl.ShopAddressDaoImpl;
import com.briup.estore.service.CustomerService;
import com.briup.estore.service.OrderService;
import com.briup.estore.service.ShopAddressService;
import com.briup.estore.service.impl.CustomerServiceImpl;
import com.briup.estore.service.impl.OrderServiceImpl;
import com.briup.estore.service.impl.ShopAddressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name").trim();
        String password = request.getParameter("password");

        // 如果用户名或密码为空或空白
        if ("".equals(name) || "".equals(password) || name == null || password == null) {
            HttpSession session = request.getSession();
            session.setAttribute("login_msg", "用户名密码不能为空！");
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }

        CustomerService customerService = new CustomerServiceImpl(new CustomerDaoImpl());
        Customer customer;
        try {
            customer = customerService.login(name, password);

            // 登陆成功
            // 将用户置入session
            HttpSession session = request.getSession();
            session.setAttribute("customer", customer);

            // 并将用户所有地址信息查出扔到session里
            ShopAddressService shopAddressService = new ShopAddressServiceImpl(new ShopAddressDaoImpl());
            List<ShopAddress> addresses = shopAddressService.findShopAddressesByCustomerId(customer.getId());
            session.setAttribute("addresses", addresses);
            // 并将用户所有订单信息插入扔到session里
            OrderService orderService = new OrderServiceImpl(new OrderDaoImpl());
            List<OrderFormEX> orders = orderService.findOrdersAllPropertiesByCustomerId(customer.getId());
            request.getSession().setAttribute("orders", orders);

            // 跳转到指定页面
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // 登陆失败
            HttpSession session = request.getSession();
            session.setAttribute("login_msg", e.getMessage());
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
