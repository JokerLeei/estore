package com.briup.estore.service.impl;

import com.briup.estore.bean.ShopAddress;
import com.briup.estore.dao.ShopAddressDao;
import com.briup.estore.service.ShopAddressService;

import java.util.List;

public class ShopAddressServiceImpl implements ShopAddressService {
    private ShopAddressDao shopAddressDao;

    public ShopAddressServiceImpl(ShopAddressDao shopAddressDao) {
        this.shopAddressDao = shopAddressDao;
    }


    @Override
    public ShopAddress findShopAddressById(Integer id) {
        return shopAddressDao.findShopAddressById(id);
    }

    @Override
    public List<ShopAddress> findShopAddressesByCustomerId(Integer customerId) {
        return shopAddressDao.findShopAddressesByCustomerId(customerId);
    }
}
