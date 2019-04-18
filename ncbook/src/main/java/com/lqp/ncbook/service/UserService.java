package com.lqp.ncbook.service;

import com.lqp.ncbook.dao.UserDao;
import com.lqp.ncbook.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public int addUser(User user)
    {
        return userDao.addUser(user);
    }

    public User getUser(String email)
    {
        return userDao.selectByEmail(email);
    }

    public User getUser(int uid)
    {
        return userDao.selectById(uid);
    }

}
