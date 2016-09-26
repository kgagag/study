package com.gray.user.dao;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.gray.user.entity.User;
@Repository
public interface UserDao<User>{
	List<User> selectId(String username);
}