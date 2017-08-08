package com.citi.gunrose.service.impl;

import com.citi.gunrose.dao.UserDao;
import com.citi.gunrose.persistence.model.User;
import com.citi.gunrose.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by miaochangfu on 2017/8/8.
 */
@Service("userService")
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> queryList(User user){
       return userDao.queryList(user);
    }
}
