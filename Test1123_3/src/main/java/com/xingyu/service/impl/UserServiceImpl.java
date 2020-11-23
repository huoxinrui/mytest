package com.xingyu.service.impl;

import com.xingyu.dao.IUserDao;
import com.xingyu.domain.UserInfo;
import com.xingyu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo=userDao.findByUsername(username);

        User user=new User(userInfo.getUsername(),userInfo.getPassword(),null);
        return user;
    }
}
