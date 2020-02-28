package com.briup.estore.dao;

import com.briup.estore.bean.OrderForm;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.bean.ex.OrderFormEX;
import com.briup.estore.bean.ex.OrderLineEX;

import java.util.List;

public interface OrderDao {
    // 查询某用户所有订单(这个订单OrderForm包含所有信息：所关联的ShopAddress、OrderLine)
    List<OrderFormEX> findOrdersAllPropertiesByCustomerId(Integer customerId);
    // 查询某订单的所有订单项
    List<OrderLineEX> findOrderLinesByOrderFormId(Integer orderFormId);

    int insertOrderForm(OrderForm orderForm);

    int insertOrderLine(OrderLine orderLine);

    int deleteOrderFormById(Integer orderFormId);

    int deleteOrderLineByOrderFormId(Integer orderFormId);

    OrderForm findOrderFormById(Integer id);
}
