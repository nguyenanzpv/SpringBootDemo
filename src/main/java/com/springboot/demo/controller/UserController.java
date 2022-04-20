package com.springboot.demo.controller;

import com.springboot.demo.entity.Users;
import com.springboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public Users create(@RequestBody Users user) {
        return userService.create(user);
    }

    @PutMapping("/{id}")
    public Users update(@PathVariable Long id, @RequestBody Users user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @GetMapping
    public Iterable<Users> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Users findByID(@PathVariable Long id) {
        return userService.findById(id);
    }
}
