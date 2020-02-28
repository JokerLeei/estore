package com.briup.estore.service;

import com.briup.estore.bean.Customer;

public interface CustomerService {
    // 登陆功能实现
    Customer login(String name,String password) throws Exception;

    // 注册功能实现
    void register(Customer customer) throws Exception;
}
