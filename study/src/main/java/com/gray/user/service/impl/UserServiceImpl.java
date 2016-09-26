package com.gray.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gray.user.dao.UserDao;
import com.gray.user.entity.User;
import com.gray.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao<User> dao;

    public boolean doUserLogin(User user) {
        List<User> list = dao.selectId(user.getUsername());
        if (list.size() == 0) {
            return false;
        }
        else {
            if (list.get(0).getPassword().equals(user.getPassword())) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    public void insert(User user) {
        this.dao.insert(user);
    }
}
