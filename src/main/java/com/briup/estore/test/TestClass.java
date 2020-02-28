package com.briup.estore.test;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.CustomerExample;
import com.briup.estore.mapper.CustomerMapper;
import com.briup.util.MybatisSqlSessionFactory;
import org.junit.Test;

import java.util.List;

public class TestClass {
    @Test
    public void test1() {
        CustomerMapper mapper = MybatisSqlSessionFactory.getMapper(CustomerMapper.class);
        CustomerExample example = new CustomerExample();
        CustomerExample.Criteria criteria = example.createCriteria();

        criteria.andNameIsNotNull();
        List<Customer> customers = mapper.selectByExample(example);
        customers.forEach(System.out::println);

        /*System.out.println(mapper.countByExample(example));*/


    }
}
