package com.hbeu.ssm.service;

import com.hbeu.ssm.domain.Product;

import java.util.List;

/**
 * @author 陈旺生
 * @create 2019-11-07 11:12
 */
public interface IProductService {
    //查询所有
    public List<Product> findAll(int page, int size) throws Exception;

    //查询前5条数据
    List<Product> findByCategoryId(String categoryId) throws Exception;

    List<Product> findAllByCategoryId(String categoryId) throws Exception;

    //模糊查询
    List<Product> dimFindProduct(String name);
}
