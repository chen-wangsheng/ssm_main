package com.hbeu.ssm.service.impl;

import com.hbeu.ssm.dao.ICategoryDao;
import com.hbeu.ssm.domain.Category;
import com.hbeu.ssm.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 陈旺生
 * @create 2019-11-17 19:47
 */
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryDao categoryDao;

    @Override
    public List<Category> findAll() throws Exception {
        return categoryDao.findAll();
    }

    @Override
    public String findCategoryName(String categoryId) {
        return categoryDao.findCategoryName(categoryId);
    }

}
