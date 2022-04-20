package com.springboot.demo.service;

import com.springboot.demo.entity.Users;

public interface UserService {
    Users create(Users user);
    Users update(Long id, Users user);
    void delete(Long id);
    Users findById(Long id);
    Iterable<Users> findAll();
}
