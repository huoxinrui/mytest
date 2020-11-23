package com.xingyu.dao;

import com.xingyu.domain.Orders;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderDao {


    /**
     *
     * @param id
     * @return
     */
    @Select("select * from orders where id=#{id}")
    @Results(id="orderMap" ,value = {
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "productId",column = "productId"),
            @Result(property = "memberId",column = "memberId"),

            @Result(property = "travellers",column = "id",many = @Many(select="com.xingyu.dao.ITravellerDao.findByOId",fetchType = FetchType.LAZY)),
            @Result(property = "member",column = "memberId",one = @One(select="com.xingyu.dao.IMemberDao.findById",fetchType = FetchType.EAGER)),
            @Result(property = "product",column = "productId",one = @One(select="com.xingyu.dao.IProductDao.findById",fetchType = FetchType.EAGER))
    })
    Orders findById(int id);

    /**
     * 查询所有，多表查询，涉及4张表
     * @return
     */
    @Select("select * from orders")
    @ResultMap("orderMap")
    List<Orders> findAll();
}
