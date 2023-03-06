package com.akhkyamiev.spring.springboot.dao;

import com.akhkyamiev.spring.springboot.models.User;

import java.util.List;

public interface UserDao {
    List<User> listAllUsers();
    User getUser(int id);
    void save(User user);
    void update(User user);
    void delete(int id);
}
