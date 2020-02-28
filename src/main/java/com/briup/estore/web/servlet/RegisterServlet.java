package com.briup.estore.web.servlet;

import com.briup.estore.bean.Customer;
import com.briup.estore.dao.impl.CustomerDaoImpl;
import com.briup.estore.service.CustomerService;
import com.briup.estore.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取表单提交param
        // 封装成Customer对象
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String zipCode = request.getParameter("zipCode");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");

        Customer customer = new Customer();
        customer.setName(name);
        customer.setPassword(password);
        customer.setZip(Integer.parseInt(zipCode));
        customer.setTelephone(telephone);
        customer.setEmail(email);

        // 2.注册业务逻辑 com.briup.estore.service.impl
        // 调用register相关方法
        CustomerService customerService = new CustomerServiceImpl(new CustomerDaoImpl());
        try {
            customerService.register(customer);

            // 注册成功，输出提示以及页面跳转
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<div style=\"font-size:30px\" align=\"center\">注册成功！</div>");
            response.setHeader("refresh", "2;URL=" + request.getContextPath() + "/login.jsp");
            /*request.getRequestDispatcher(request.getContextPath()+"/register.jsp");*/
        } catch (Exception e) {
            // 用户名被占用
            System.out.println(e.getMessage());
            HttpSession session = request.getSession();
            session.setAttribute("msg", e.getMessage());
            response.sendRedirect(request.getContextPath()+"/register.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
