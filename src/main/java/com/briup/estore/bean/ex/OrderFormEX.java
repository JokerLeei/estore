package com.briup.estore.bean.ex;

import com.briup.estore.bean.OrderForm;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.bean.ShopAddress;

import java.util.List;

public class OrderFormEX extends OrderForm {

    // shopaddressId值得到一个shopAddress对象
    private ShopAddress shopAddress;

    // 属于该订单的所有订单项
    private List<OrderLine> orderLines;


    public ShopAddress getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(ShopAddress shopAddress) {
        this.shopAddress = shopAddress;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    @Override
    public String toString() {
        return "OrderFormEX{" +
                "shopAddress=" + shopAddress +
                ", orderLines=" + orderLines +
                '}';
    }
}
