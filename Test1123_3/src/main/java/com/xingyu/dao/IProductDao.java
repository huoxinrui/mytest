package com.xingyu.dao;

import com.xingyu.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductDao {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from product")
    List<Product> findAll();

    /**
     * 添加产品信息
     * @param product
     */
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from product where id=#{id}")
    Product findById(Integer id);
}
