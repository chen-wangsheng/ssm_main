package com.hbeu.ssm.dao;

import com.hbeu.ssm.domain.Orders;
import com.hbeu.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 陈旺生
 * @create 2019-11-21 18:21
 */
public interface IOrdersDao {
    //查询当前用户未支付的订单
    @Select("select * from orders where memberId=#{memberId}")
    @Results({
            @Result(id=true,column = "id",property="id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "productCount",property = "productCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(
                    select = "com.hbeu.ssm.dao.IProductDao.findById"))
    })
    List<Orders> findByMemberId(String memberId) throws Exception;

    @Select("select * from orders where memberId=#{memberId} and productId=#{productId} and orderStatus=0")
    @Results({
            @Result(id=true,column = "id",property="id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "productCount",property = "productCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(
                    select = "com.hbeu.ssm.dao.IProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Product.class,one = @One(
                    select = "com.hbeu.ssm.dao.IMemberDao.findById"))
    })
    Orders findByMemberIdAndProductId(@Param("productId") String productId,@Param("memberId")String memberId) throws Exception;

    @Update("update orders set orderTime=#{orders.orderTime},productCount=#{orders.productCount} where memberId=#{orders.member.id} and productId=#{orders.product.id}")
    int updateOrderByProductId(@Param("orders") Orders orders) throws Exception;

    @Insert("insert into orders(orderNum,orderTime,productCount,orderStatus,productId,memberId) values(#{orders.orderNum},#{orders.orderTime},#{orders.productCount},#{orders.orderStatus},#{productId},#{memberId})")
    int addOrders(@Param("orders") Orders orders,@Param("productId") String productId,@Param("memberId") String memberId);

    @Update("update orders set orderTime=#{orders.orderTime},payType=#{orders.payType},orderStatus=#{orders.orderStatus} where memberId=#{orders.member.id} and productId=#{orders.product.id}")
    void updateStatus(@Param("orders") Orders orders);

    @Delete("delete from orders where id=#{orderId}")
    int deleteById(String orderId);
}
