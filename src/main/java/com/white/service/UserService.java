package com.white.service;

import com.white.entity.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    User getUser(Integer id);

    List<User> getAllUsers();

    void deleteUser(Integer id);
}
