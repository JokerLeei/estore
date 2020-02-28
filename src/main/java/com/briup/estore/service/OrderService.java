package com.briup.estore.service;

import com.briup.estore.bean.OrderForm;
import com.briup.estore.bean.ShopAddress;
import com.briup.estore.bean.ex.OrderFormEX;
import com.briup.estore.bean.ex.OrderLineEX;
import com.briup.estore.bean.ex.ShopCart;

import java.util.List;

public interface OrderService {
    List<OrderFormEX> findOrdersAllPropertiesByCustomerId(Integer customerId);

    List<OrderLineEX> findOrderLinesByOrderFormId(Integer orderFormId);

    // servlet已经准备好提交订单的数据，准备向DB插入这仨种表的数据
    void insertOrderFormAndOrderLinesAndAddress(ShopCart shopCart, ShopAddress shopAddress,Integer customerId);
    // 删除OrderForm及其(子表)所关联的OrderLine数据
    void deleteOrderFormAndOrderLineByOrderFormId(Integer orderFormId);

    OrderForm findOrderFormById(Integer id);
}
