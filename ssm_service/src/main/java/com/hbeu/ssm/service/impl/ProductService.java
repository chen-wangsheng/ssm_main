package com.hbeu.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.hbeu.ssm.dao.IProductDao;
import com.hbeu.ssm.domain.Product;
import com.hbeu.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 陈旺生
 * @create 2019-11-07 11:16
 */
@Service
@Transactional
public class ProductService implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll(int page,int size) throws Exception {
         PageHelper.startPage(page,size);
        return productDao.findAll();
    }

    @Override
    public List<Product> findByCategoryId(String categoryId) throws Exception {
        return productDao.findByCategoryId(categoryId);
    }

    @Override
    public List<Product> findAllByCategoryId(String categoryId) throws Exception {
        return productDao.findAllByCategoryId(categoryId);
    }

    @Override
    public List<Product> dimFindProduct(String name) {
        return productDao.dimFindProduct(name);
    }

}
