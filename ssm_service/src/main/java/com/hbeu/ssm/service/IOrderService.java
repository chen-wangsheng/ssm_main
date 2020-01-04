package com.hbeu.ssm.service;

import com.hbeu.ssm.domain.Orders;

import java.util.List;

/**
 * @author 陈旺生
 * @create 2019-11-21 18:34
 */
public interface IOrderService {

    List<Orders> findByMemberId(String memberId,int status) throws Exception;

    Orders findByMemberIdAndProductId(String productId, String memberId) throws Exception;

    //将未支付商品数量+1
    int updateOrderByProductId(Orders orders) throws Exception;

    //生成订单（购物车）
    int addOrders(String productId, String memberId);

    int addOrDeleteNumber(Orders orders,int productCount) throws Exception;

    void updateStatus(String memberId, String productId) throws Exception;

    int deleteById(String orderId) throws Exception;
}
