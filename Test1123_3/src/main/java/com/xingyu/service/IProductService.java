package com.xingyu.service;

import com.xingyu.domain.Product;

import java.util.List;

public interface IProductService {
    /**
     * 查询所有
     * @return
     */
    List<Product> findAll();

    /**
     * 添加产品信息
     * @param product
     */
    void save(Product product);
}
