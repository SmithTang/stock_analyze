package com.citi.gunrose.dao.impl;

import com.citi.gunrose.dao.UserDao;
import com.citi.gunrose.persistence.model.User;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by miaochangfu on 2017/8/8.
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    public List<User> queryList(User user) {
        SQLQuery sqlQuery = this.getSession().createSQLQuery("select * from user as s where s.UserName ='"+user.getUserName()+"'and s.Password='"+user.getPassword()+"'");
        sqlQuery.addEntity(User.class);
        List<User> users = sqlQuery.list();

        return users;
    }

}
