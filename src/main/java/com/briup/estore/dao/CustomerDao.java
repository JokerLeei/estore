package com.briup.estore.dao;

import com.briup.estore.bean.Customer;

public interface CustomerDao {
    // 根据用户名查找出Customer(查找到返回该Customer，不存在返回null)
    Customer findCustomerByUsername(String username);
    // 用户注册
    void saveCustomer(Customer customer);
}
