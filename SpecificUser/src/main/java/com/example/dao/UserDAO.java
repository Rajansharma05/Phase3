package com.example.dao;

import com.example.model.User;

import java.util.List;

public interface UserDAO {
    User getUserById(Long id);

    List<User> getAllUsers();

    void saveOrUpdateUser(User user);

    void deleteUser(Long id);
}
