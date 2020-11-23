package com.xingyu.dao;

import com.xingyu.domain.UserInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao {
    @Select("select * from users where username=#{username}")
    UserInfo findByUsername(String username);
}
