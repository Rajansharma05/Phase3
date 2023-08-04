package com.example.SpringSecurityAuthentication.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.SpringSecurityAuthentication.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    public User findByName(String name);
}