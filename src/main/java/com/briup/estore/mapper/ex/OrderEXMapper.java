package com.briup.estore.mapper.ex;

import com.briup.estore.bean.ex.OrderFormEX;
import com.briup.estore.bean.ex.OrderLineEX;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderEXMapper {
    // 根据customerId查询出这个人所有订单(订单包括订单项、订单地址对象所有属性)
    List<OrderFormEX> findOrdersAllPropertiesByCustomerId(@Param("customerId") Integer id);
    // 根据orderFormId查找出所有的orderLineEX(其中包括book对象属性)
    List<OrderLineEX> findOrderLinesByOrderFormId(@Param("orderFormId") Integer orderFormId);
}
