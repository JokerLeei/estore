package com.briup.estore.service.impl;

import com.briup.estore.bean.Customer;
import com.briup.estore.dao.CustomerDao;
import com.briup.estore.service.CustomerService;


public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao=customerDao;
    }


    @Override
    public Customer login(String name, String password) throws Exception {
        Customer customer = customerDao.findCustomerByUsername(name);
        if(customer==null){
            // 账号不存在
            throw new Exception("用户名或密码错误！");
        }else{
            // 账号存在，但密码错误
            if(!password.equals(customer.getPassword())){
                throw new Exception("用户名或密码错误！");
            }else{
                // 账号存在，并且这个账号的密码和前台传来的密码一致，则返回这个customer对象
                System.out.println(customer);
                return customer;
            }
        }
    }

    @Override
    public void register(Customer customer) throws Exception {
        // 先判断这个用户名是否被占用，如果没占用再向数据库插入数据
        Customer c = customerDao.findCustomerByUsername(customer.getName());
        if(c!=null){
            throw new Exception("用户已存在！");
        }else{
            customerDao.saveCustomer(customer);
        }
    }
}
