package com.citi.gunrose.service;

import com.citi.gunrose.persistence.model.User;

import java.util.List;

/**
 * Created by miaochangfu on 2017/8/8.
 */
public interface UserService extends BaseService<User> {

    public List<User> queryList(User user);
}
