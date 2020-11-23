package com.xingyu.dao;

import com.xingyu.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface IMemberDao {
    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from member where id=#{id}")
    Member findById(Integer id);
}
