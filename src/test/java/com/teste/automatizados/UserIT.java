package com.teste.automatizados;

import com.teste.automatizados.services.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

//Aqui vamos testar toda aplicação = Integração Total
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void createUser(){
        User user = new User("Rafa", "007");

     User[] users =   restTemplate.postForObject("/users", user, User[].class);

        assertNotNull(users);
        assertEquals(1, users.length);
        assertEquals(user, users[0]);
        assertThrows(RuntimeException.class,
                () -> restTemplate.postForObject("/users",
                        user, User[].class));
    }
}
