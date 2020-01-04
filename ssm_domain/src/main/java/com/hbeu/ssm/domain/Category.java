package com.hbeu.ssm.domain;

import java.util.List;

/**
 * @author 陈旺生
 * @create 2019-11-17 18:06
 */
public class Category {
    private String id;
    private String categoryName;
    private List<Product> products;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
