package com.teste.automatizados.services;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserService userService = new UserService();

    @Test
    public void createUser_ReturnUsers() {
        //Arrange
        User user = new User("Rafa", "007");

        //Action
        List<User> users = userService.create(user);

        //Assert junit
        assertEquals(1, users.size());
        assertEquals(user, users.get(0));

    }

    @Test
    public void createUser_ThrowsException() {
        User user = new User("Rafa", "007");
        userService.create(user);


        assertThrows(RuntimeException.class,
                ()-> userService.create(user));


    }
}