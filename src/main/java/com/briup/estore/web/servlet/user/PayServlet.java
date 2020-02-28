package com.briup.estore.web.servlet.user;

import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.briup.estore.bean.Customer;
import com.briup.estore.bean.OrderForm;
import com.briup.estore.dao.impl.OrderDaoImpl;
import com.briup.estore.service.OrderService;
import com.briup.estore.service.impl.OrderServiceImpl;
import com.briup.util.AlipayConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PayServlet", urlPatterns = "/user/payServlet")
public class PayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            AlipayClient alipayClient = AlipayConfig.getAlipayClient();
            //设置请求参数
            AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();

            AlipayTradePayModel model = new AlipayTradePayModel();

            // 设定订单号 必须要写,且订单号不能重复，目前已经只是做测试，已经写死
            model.setOutTradeNo("00001");
            // 设置订单金额
            int id = Integer.parseInt(request.getParameter("id"));
            OrderService orderServic = new OrderServiceImpl(new OrderDaoImpl());
            OrderForm orderForm = orderServic.findOrderFormById(id);
            // ***** 如果找到的这个orderform的customerId和当前登录用户id不同
            // ***** 则是用户输入了非法请求行，进行相关处理：
            Customer customer = (Customer) request.getSession().getAttribute("customer");
            if (customer.getId() != orderForm.getCustomerId()) {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("请求非法！");
                response.setHeader("refresh", "2;URL=" + request.getContextPath() + "/user/orderlist.jsp");
            }
            model.setTotalAmount(orderForm.getCost() + "");
            // 订单名字
            model.setSubject("书籍订单");
            // 订单描述
            model.setBody(System.currentTimeMillis() + "");
            // 产品码
            model.setProductCode("FAST_INSTANT_TRADE_PAY");
            // 设置参数
            alipayRequest.setBizModel(model);
            // 设置回调地址
            alipayRequest.setReturnUrl(AlipayConfig.return_url);
            String result = alipayClient.pageExecute(alipayRequest).getBody();
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
