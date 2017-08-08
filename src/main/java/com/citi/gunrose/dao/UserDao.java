package com.citi.gunrose.dao;

import com.citi.gunrose.persistence.model.User;

import java.util.List;

/**
 * Created by miaochangfu on 2017/8/8.
 */
public interface UserDao extends BaseDao<User> {
    public List<User> queryList(User user);
}
