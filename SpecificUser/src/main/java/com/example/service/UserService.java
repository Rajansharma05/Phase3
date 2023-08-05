package com.example.service;

import com.example.model.User;

import com.example.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional
    public void saveOrUpdateUser(User user) {
        userDAO.saveOrUpdateUser(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }

    @Transactional
    public void updateUserInformation(Long id, String username, String email) {
        User user = userDAO.getUserById(id);
        if (user != null) {
            user.setUsername(username);
            user.setEmail(email);
            userDAO.saveOrUpdateUser(user);
        }
    }
}
