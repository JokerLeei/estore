package com.briup.estore.dao.impl;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.CustomerExample;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.dao.CustomerDao;
import com.briup.estore.mapper.CustomerMapper;
import com.briup.util.MybatisSqlSessionFactory;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public Customer findCustomerByUsername(String username) {
        CustomerMapper mapper = MybatisSqlSessionFactory.getMapper(CustomerMapper.class);
        CustomerExample example=new CustomerExample();
        CustomerExample.Criteria criteria = example.createCriteria();

        criteria.andNameEqualTo(username);

        List<Customer> customers = mapper.selectByExample(example);
        if(!customers.isEmpty()){
            return customers.get(0);
        }
        return null;
    }

    @Override
    public void saveCustomer(Customer customer) {
        CustomerMapper mapper = MybatisSqlSessionFactory.getMapper(CustomerMapper.class);

        mapper.insert(customer);
    }


}
