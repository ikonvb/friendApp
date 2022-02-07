package com.bulyginkonstantin.friend_app.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClientTest {

    Client client;

    @BeforeEach
    void setUp() {
        client = new Client();
    }

    @Test
    void getUserName() {
        client.setUserName("test");
        assertEquals("test", client.getUserName());
    }

    @Test
    void setUserName() {
        client.setUserName("test");
        assertEquals("test", client.getUserName());
    }

    @Test
    void getId() {
        client.setId(13);
        assertEquals(13, client.getId());
    }

    @Test
    void setId() {
        client.setId(13);
        assertEquals(13, client.getId());
    }

    @Test
    void getLogin() {
        client.setLogin("login");
        assertEquals("login", client.getLogin());
    }

    @Test
    void setLogin() {
        client.setLogin("login");
        assertEquals("login", client.getLogin());
    }

    @Test
    void getEmail() {
        client.setEmail("email@email.com");
        assertEquals("email@email.com", client.getEmail());
    }

    @Test
    void setEmail() {
        client.setEmail("email@email.com");
        assertEquals("email@email.com", client.getEmail());
    }

    @Test
    void getPassword() {
        client.setPassword("123456");
        assertEquals("123456", client.getPassword());
    }

    @Test
    void setPassword() {
        client.setPassword("123456");
        assertEquals("123456", client.getPassword());
    }

    @Test
    void getConfirmPassword() {
        client.setConfirmPassword("123456");
        assertEquals("123456", client.getConfirmPassword());
    }

    @Test
    void setConfirmPassword() {
        client.setConfirmPassword("123456");
        assertEquals("123456", client.getConfirmPassword());
    }
}