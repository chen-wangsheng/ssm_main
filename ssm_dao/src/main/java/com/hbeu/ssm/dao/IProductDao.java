package com.hbeu.ssm.dao;

import com.hbeu.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 陈旺生
 * @create 2019-11-07 11:00
 */
public interface IProductDao {

    //查询所有商品信息
    @Select("select * from product")
     @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "productNnm",property = "productNnm"),
            @Result(column = "productName",property = "productName"),
            @Result(column = "cityName",property = "cityName"),
            @Result(column = "departureTime",property = "departureTime"),
            @Result(column = "productPrice",property = "productPrice"),
            @Result(column = "productDesc",property = "productDesc"),
            @Result(column = "productStatus",property = "productStatus"),
            @Result(column = "productPic",property = "productPic"),
            @Result(column = "categoryId",property = "category",one = @One(select =
                    "com.hbeu.ssm.dao.ICategoryDao.findById"))
    })
    List<Product> findAll() throws Exception;

    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus,productPic) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus},#{productPic})")
    void save(Product product);

    //通过ID查询商品
    @Select("select * from product where id=#{productId}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "productNnm",property = "productNnm"),
            @Result(column = "productName",property = "productName"),
            @Result(column = "cityName",property = "cityName"),
            @Result(column = "departureTime",property = "departureTime"),
            @Result(column = "productPrice",property = "productPrice"),
            @Result(column = "productDesc",property = "productDesc"),
            @Result(column = "productStatus",property = "productStatus"),
            @Result(column = "productPic",property = "productPic")
    })
    Product findById(String productId) throws Exception;

    @Select("select * from product where categoryId=#{categoryId}")
    List<Product> findAllByCategoryId(String categoryId) throws Exception;

    //通过类别id查询前五条商品数据
    @Select("select * from product where categoryId=#{categoryId} and rownum < 6")
    List<Product> findByCategoryId(String categoryId) throws Exception;

    @Select("select * from product where productName like CONCAT(concat('%',#{name}),'%')")
    List<Product> dimFindProduct(String name);
}
