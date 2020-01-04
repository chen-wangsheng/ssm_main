package com.hbeu.ssm.service.impl;

import com.hbeu.ssm.dao.IOrdersDao;
import com.hbeu.ssm.domain.Orders;
import com.hbeu.ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author 陈旺生
 * @create 2019-11-21 18:34
 */
@Service
@Transactional
public class OrderService implements IOrderService {

    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public List<Orders> findByMemberId(String memberId,int status) throws Exception {
        List<Orders> orders = new ArrayList<>();
        List<Orders> ordersList = ordersDao.findByMemberId(memberId);
        for (Orders order1 : ordersList) {
            if(order1.getOrderStatus()==0){
                orders.add(order1);//未支付
            }
        }
        if(status==0){
            return orders;//未支付订单
        }else {
            return ordersList;//所有订单
        }
    }

    @Override
    public Orders findByMemberIdAndProductId(String productId, String memberId) throws Exception {
        return ordersDao.findByMemberIdAndProductId(productId,memberId);
    }

    @Override
    public int updateOrderByProductId(Orders orders) throws Exception {
        orders.setOrderTime(new Date());
        orders.setProductCount(orders.getProductCount()+1);
        return ordersDao.updateOrderByProductId(orders);
    }

    @Override
    public int addOrders(String productId, String memberId) {
        Orders orders = new Orders();
        String orderId = UUID.randomUUID().toString().replace("-","").substring(0,15);

        orders.setOrderTime(new Date());
        orders.setProductCount(1);
        orders.setOrderNum(orderId);
        orders.setOrderStatus(0);
        return ordersDao.addOrders(orders,productId,memberId);
    }

    @Override
    public int addOrDeleteNumber(Orders orders,int productCount) throws Exception {
        orders.setOrderTime(new Date());
        orders.setProductCount(productCount);
        return ordersDao.updateOrderByProductId(orders);
    }

    @Override
    public void updateStatus(String memberId, String productId) throws Exception {
        //查询到需要更新的订单数据
        Orders orders = ordersDao.findByMemberIdAndProductId(productId,memberId);
        //设置需要更改的数据
        orders.setOrderTime(new Date());
        orders.setOrderStatus(1);
        //支付方式 0:支付宝，1:微信，2:其他，null:未知
        orders.setPayType(0);
        ordersDao.updateStatus(orders);
    }

    @Override
    public int deleteById(String orderId) throws Exception{
        return ordersDao.deleteById(orderId);
    }
}
