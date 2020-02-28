package com.briup.estore.dao.impl;

import com.briup.estore.bean.ShopAddress;
import com.briup.estore.bean.ShopAddressExample;
import com.briup.estore.dao.ShopAddressDao;
import com.briup.estore.mapper.ShopAddressMapper;
import com.briup.util.MybatisSqlSessionFactory;

import java.util.List;

public class ShopAddressDaoImpl implements ShopAddressDao {

    @Override
    public ShopAddress findShopAddressById(Integer id) {
        ShopAddressMapper mapper = MybatisSqlSessionFactory.getMapper(ShopAddressMapper.class);
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ShopAddress> findShopAddressesByCustomerId(Integer customerId) {
        ShopAddressMapper mapper = MybatisSqlSessionFactory.getMapper(ShopAddressMapper.class);
        ShopAddressExample example = new ShopAddressExample();
        ShopAddressExample.Criteria criteria = example.createCriteria();
        criteria.andCustomerIdEqualTo(customerId);

        return mapper.selectByExample(example);
    }

    @Override
    public int insertShopAddress(ShopAddress shopAddress) {
        ShopAddressMapper mapper = MybatisSqlSessionFactory.getMapper(ShopAddressMapper.class);
        return mapper.insert(shopAddress);
    }
}
