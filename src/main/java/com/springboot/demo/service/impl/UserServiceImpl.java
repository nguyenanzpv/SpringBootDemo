package com.springboot.demo.service.impl;

import com.springboot.demo.entity.Users;
import com.springboot.demo.repository.UserRepository;
import com.springboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Users create(Users user) {
        if (user.getEmail() == null  || user.getEmail().isEmpty()) {
            return null;
        }
        if (user.getName() == null  || user.getName().isEmpty()) {
            return null;
        }
        return userRepository.save(user);
    }

    @Override
    public Users update(Long id, Users user) {
        Users fromDB = userRepository.findById(id).orElse(null);
        if (fromDB == null) {
            return null;
        }
        fromDB.setEmail(user.getEmail());
        fromDB.setName(user.getName());
        return userRepository.save(fromDB);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Users findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Users> findAll() {
        return userRepository.findAll();
    }
}
