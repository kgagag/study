package com.gray.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gray.user.entity.PayVO;

@Repository
public interface UserDao<User> {
    List<User> selectId(String username);

    void insert(User user);

    List<PayVO> getPay(int time);
}
