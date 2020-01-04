package com.hbeu.ssm.dao;

import com.hbeu.ssm.domain.Category;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 陈旺生
 * @create 2019-11-17 18:16
 */
public interface ICategoryDao {
    @Select("select * from category")
    List<Category> findAll() throws Exception;

    @Select("select * from category where id=#{categoryId}")
     @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "categoryName",property = "categoryName"),
            @Result(column = "id",property = "products",javaType = java.util.List.class,many = @Many(select =
                    "com.hbeu.ssm.dao.IProductDao.findByCategoryId"))
    })
    Category findById(String categoryId) throws Exception;

    @Select("select categoryName from category where id=#{categoryId}")
    String findCategoryName(String categoryId);
}
