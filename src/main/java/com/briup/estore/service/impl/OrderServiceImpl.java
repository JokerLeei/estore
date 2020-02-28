package com.briup.estore.service.impl;

import com.briup.estore.bean.OrderForm;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.bean.ShopAddress;
import com.briup.estore.bean.ex.OrderFormEX;
import com.briup.estore.bean.ex.OrderLineEX;
import com.briup.estore.bean.ex.ShopCart;
import com.briup.estore.dao.OrderDao;
import com.briup.estore.dao.ShopAddressDao;
import com.briup.estore.service.OrderService;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;
    private ShopAddressDao shopAddressDao;

    public OrderServiceImpl(OrderDao orderEXDao) {
        this.orderDao = orderEXDao;
    }

    public OrderServiceImpl(OrderDao orderEXDao, ShopAddressDao shopAddressDao) {
        this.orderDao = orderEXDao;
        this.shopAddressDao = shopAddressDao;
    }


    @Override
    public List<OrderFormEX> findOrdersAllPropertiesByCustomerId(Integer customerId) {
        return orderDao.findOrdersAllPropertiesByCustomerId(customerId);
    }

    @Override
    public List<OrderLineEX> findOrderLinesByOrderFormId(Integer orderFormId) {
        return orderDao.findOrderLinesByOrderFormId(orderFormId);
    }

    @Override
    public void insertOrderFormAndOrderLinesAndAddress(ShopCart shopCart, ShopAddress shopAddress, Integer customerId) {
        // 准备分解shopCart对象
        Map<Integer, OrderLineEX> cart = shopCart.getCart();

        System.out.println("---------------------------------");
        System.out.println(cart);
        System.out.println(shopAddress);
        System.out.println(customerId);
        System.out.println("---------------------------------");


        System.out.println("*********************************************");
        // 如果是新增出来的shopAddress(shopAddress.id为null)才插入shopAddress
        if(shopAddress.getId()==null){
            // 插入到es_shopaddress表中
            // 为shopAddress设置外键值(customerId)
            shopAddress.setCustomerId(customerId);
            shopAddressDao.insertShopAddress(shopAddress);
        }

        System.out.println("shopAddress");
        System.out.println(shopAddress);

        // 插入到es_orderform表中
        // 分析前台数据，构造新的orderForm对象，准备执行插入操作
        OrderForm orderForm = new OrderForm();
        orderForm.setCost(shopCart.getTotal());
        orderForm.setOrderdate(new Date());
        orderForm.setShopaddressId(shopAddress.getId());
        orderForm.setCustomerId(customerId);
        orderDao.insertOrderForm(orderForm);

        System.out.println("orderForm");
        System.out.println(orderForm);
        System.out.println("orderFormId:"+orderForm.getId());

        // 插入到es_orderLine表中
        // 拆解cart(map)中的每个OrderLineEX，然后遍历这个map将每个成员插入数据库
        for (Integer index : cart.keySet()) {
            // OrderLineEX 上转 OrderLine
            OrderLine orderLine = cart.get(index);
            // 为OrderLine设置外键值(es_orderLine的orderForm_id列，值为es_orderForm的id)
            orderLine.setOrderformId(orderForm.getId());
            orderDao.insertOrderLine(orderLine);

            System.out.println("orderLine");
            System.out.println(orderLine);
        }
        System.out.println("*********************************************");

    }

    @Override
    public void deleteOrderFormAndOrderLineByOrderFormId(Integer orderFormId) {
        // 先删除子表数据 orderLine
        orderDao.deleteOrderLineByOrderFormId(orderFormId);
        // 再删除父表数据 orderForm
        orderDao.deleteOrderFormById(orderFormId);
    }

    @Override
    public OrderForm findOrderFormById(Integer id) {
        return orderDao.findOrderFormById(id);
    }
}
