package com.xingyu.service;

import com.xingyu.domain.Orders;

import java.util.List;

//import org.junit.jupiter.api.Order;

public interface IOrderService {
    /**
     * 查询所有
     * @return
     */
    List<Orders> findAll(int pageNum, int pageSize);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Orders findById(int id);
}
