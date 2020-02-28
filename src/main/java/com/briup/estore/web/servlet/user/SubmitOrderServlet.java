package com.briup.estore.web.servlet.user;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.ShopAddress;
import com.briup.estore.bean.ex.ShopCart;
import com.briup.estore.dao.impl.OrderDaoImpl;
import com.briup.estore.dao.impl.ShopAddressDaoImpl;
import com.briup.estore.service.OrderService;
import com.briup.estore.service.ShopAddressService;
import com.briup.estore.service.impl.OrderServiceImpl;
import com.briup.estore.service.impl.ShopAddressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SubmitOrderServlet", urlPatterns = "/user/submitOrderServlet")
public class SubmitOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 前台传过来的新地址
        String receiveName = request.getParameter("receiveName");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");

        // 构造shopAddress对象
        ShopAddress shopAddress;
        if(!"".equals(receiveName)&&!"".equals(address)&&!"".equals(phone)&&receiveName!=null&&address!=null&&phone!=null){
            shopAddress = new ShopAddress();
            shopAddress.setReceivename(receiveName);
            shopAddress.setAddress(address);
            shopAddress.setPhone(phone);
        }else{
            // 地址id
            int addId = Integer.parseInt(request.getParameter("shipAddId"));
            ShopAddressService shopAddressService=new ShopAddressServiceImpl(new ShopAddressDaoImpl());
            shopAddress = shopAddressService.findShopAddressById(addId);
        }

        // 获取session中的 shopCart对象
        ShopCart shopCart = (ShopCart) request.getSession().getAttribute("shopCart");

        // 获取这个登录用户的id值
        Integer customerId = ((Customer) request.getSession().getAttribute("customer")).getId();

        // 执行相关service方法
        OrderService orderService=new OrderServiceImpl(new OrderDaoImpl(),new ShopAddressDaoImpl());
        orderService.insertOrderFormAndOrderLinesAndAddress(shopCart,shopAddress,customerId);

        // 清空购物车
        shopCart.clear();
        request.getSession().removeAttribute("shopCart");

        request.getRequestDispatcher("listOrdersServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
