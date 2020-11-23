package com.xingyu.dao;

import com.xingyu.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITravellerDao {
    /**
     * 根据OId查询
     * @param OId
     * @return
     */
    @Select("select t.* from traveller t left join order_traveller ot on ot.travellerId=t.id where ot.orderId=#{OId}")
    List<Traveller> findByOId(Integer OId);
}
