package com.briup.estore.dao;

import com.briup.estore.bean.ShopAddress;

import java.util.List;

public interface ShopAddressDao {
    // 根据主键addId查出这个shopAddress
    ShopAddress findShopAddressById(Integer id);
    // 根据customerId查出他的所有address
    List<ShopAddress> findShopAddressesByCustomerId(Integer customerId);

    int insertShopAddress(ShopAddress shopAddress);
}
