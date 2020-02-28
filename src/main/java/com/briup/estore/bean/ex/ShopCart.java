package com.briup.estore.bean.ex;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.OrderLine;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * 购物车类     ----- 这个类对象放的sessionScope，用户退出后remove掉
 */
public class ShopCart {
    // 一个购物车里一堆订单项
    // <Integer bookId, OrderLine 订单项>
    private Map<Integer, OrderLineEX> cart = new HashMap<>();

    // 添加购物车
    public void addBook(Book book, Integer num) {
        Integer id = book.getId();
        // 如果购物车已包含这个书
        if (cart.keySet().contains(id)) {
            OrderLine orderLine = cart.get(id);
            // 获取书的单价
            double price = orderLine.getCost() / orderLine.getNum();
            orderLine.setNum(orderLine.getNum() + num);
            orderLine.setCost(orderLine.getCost() + price * num);
        } else {
            OrderLineEX orderLine = new OrderLineEX();
            orderLine.setNum(num);
            orderLine.setCost(book.getPrice() * num);
            orderLine.setBookId(book.getId());
            orderLine.setBook(book);

            cart.put(book.getId(), orderLine);
        }
    }

    public void deleteById(Integer id){
        cart.remove(id);
    }

    // 清理购物车
    public void clear() {
        cart.clear();
    }

    // 购物车中OrderLine数目
    public int getSize() {
        return cart.size();
    }

    // 购物车中书本总数
    public int getNumber(){
        int result=0;
        for (Integer index : cart.keySet()) {
            result += cart.get(index).getNum();
        }
        return result;
    }

    public Map<Integer, OrderLineEX> getCart() {
        return cart;
    }

    public Double getTotal(){
        double result=0;
        for (Integer index : cart.keySet()) {
            result += cart.get(index).getCost();
        }
        return result;
    }

    @Override
    public String toString() {
        return "ShopCart{" +
                "cart=" + cart +
                '}';
    }
}
