package com.teste.automatizados.controller;

import com.teste.automatizados.services.User;
import com.teste.automatizados.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public List<User> create(@RequestBody User user){
        return userService.create(user);

    }
}
