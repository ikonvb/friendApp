package com.bulyginkonstantin.friend_app.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@SqlGroup({@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:schema.sql", "classpath:data.sql"}),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:drop.sql")})
class ClientServiceTest {


    String login;
    String userName;
    String email;
    String password;
    String confirmPassword;

    ClientService clientService;

    @BeforeEach
    void setUp() {
        clientService = new ClientService();
        login = "test";
        userName = "tester";
        email = "test@test.com";
        password = "123456";
        confirmPassword = "123456";
    }

    @Test
    void registerClient() {

    }

    @Test
    void loginClient() {

    }

    @Test
    void findAll() {
    }

    @Test
    void findAllByUserName() {
    }

    @Test
    void findById() {
    }

    @Test
    void delete() {
    }
}