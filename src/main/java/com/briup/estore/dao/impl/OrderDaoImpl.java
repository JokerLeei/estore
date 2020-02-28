package com.briup.estore.dao.impl;

import com.briup.estore.bean.OrderForm;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.bean.OrderLineExample;
import com.briup.estore.bean.ex.OrderFormEX;
import com.briup.estore.bean.ex.OrderLineEX;
import com.briup.estore.dao.OrderDao;
import com.briup.estore.mapper.OrderFormMapper;
import com.briup.estore.mapper.OrderLineMapper;
import com.briup.estore.mapper.ex.OrderEXMapper;
import com.briup.util.MybatisSqlSessionFactory;

import java.util.List;

public class OrderDaoImpl implements OrderDao {

    @Override
    public List<OrderFormEX> findOrdersAllPropertiesByCustomerId(Integer customerId) {
        OrderEXMapper mapper = MybatisSqlSessionFactory.getMapper(OrderEXMapper.class);
        return mapper.findOrdersAllPropertiesByCustomerId(customerId);
    }

    @Override
    public List<OrderLineEX> findOrderLinesByOrderFormId(Integer orderFormId) {
        OrderEXMapper mapper = MybatisSqlSessionFactory.getMapper(OrderEXMapper.class);
        return mapper.findOrderLinesByOrderFormId(orderFormId);
    }

    @Override
    public int insertOrderForm(OrderForm orderForm) {
        OrderFormMapper mapper = MybatisSqlSessionFactory.getMapper(OrderFormMapper.class);
        return mapper.insert(orderForm);
    }

    @Override
    public int insertOrderLine(OrderLine orderLine) {
        OrderLineMapper mapper = MybatisSqlSessionFactory.getMapper(OrderLineMapper.class);
        return mapper.insert(orderLine);
    }

    @Override
    public int deleteOrderFormById(Integer orderFormId) {
        OrderFormMapper mapper = MybatisSqlSessionFactory.getMapper(OrderFormMapper.class);
        return mapper.deleteByPrimaryKey(orderFormId);
    }

    @Override
    public int deleteOrderLineByOrderFormId(Integer orderFormId) {
        OrderLineMapper mapper = MybatisSqlSessionFactory.getMapper(OrderLineMapper.class);
        OrderLineExample example = new OrderLineExample();
        OrderLineExample.Criteria criteria = example.createCriteria();

        criteria.andOrderformIdEqualTo(orderFormId);

        return mapper.deleteByExample(example);
    }

    @Override
    public OrderForm findOrderFormById(Integer id) {
        OrderFormMapper mapper = MybatisSqlSessionFactory.getMapper(OrderFormMapper.class);
        return mapper.selectByPrimaryKey(id);
    }
}
