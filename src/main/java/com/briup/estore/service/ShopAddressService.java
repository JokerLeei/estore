package com.briup.estore.service;

import com.briup.estore.bean.ShopAddress;

import java.util.List;

public interface ShopAddressService {
    ShopAddress findShopAddressById(Integer id);

    List<ShopAddress> findShopAddressesByCustomerId(Integer customerId);
}
