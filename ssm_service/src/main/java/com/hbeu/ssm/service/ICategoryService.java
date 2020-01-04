package com.hbeu.ssm.service;

import com.hbeu.ssm.domain.Category;

import java.util.List;

/**
 * @author 陈旺生
 * @create 2019-11-17 19:46
 */
public interface ICategoryService {

    List<Category> findAll() throws Exception;

    String findCategoryName(String categoryId);

}
