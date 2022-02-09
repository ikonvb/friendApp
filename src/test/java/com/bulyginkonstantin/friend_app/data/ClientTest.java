package com.bulyginkonstantin.friend_app.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ClientTest {

    Client client;

    @BeforeEach
    void setUp() {
        client = new Client();
    }

    @Test
    void testGetUserName() {
        client.setUserName("test");
        assertEquals("test", client.getUserName());
    }

    @Test
    void testSetUserName() {
        client.setUserName("test");
        assertEquals("test", client.getUserName());
    }

    @Test
    void testGetId() {
        client.setId(13);
        assertEquals(13, client.getId());
    }

    @Test
    void testSetId() {
        client.setId(13);
        assertEquals(13, client.getId());
    }

    @Test
    void testGetLogin() {
        client.setLogin("login");
        assertEquals("login", client.getLogin());
    }

    @Test
    void testSetLogin() {
        client.setLogin("login");
        assertEquals("login", client.getLogin());
    }

    @Test
    void testGetEmail() {
        client.setEmail("email@email.com");
        assertEquals("email@email.com", client.getEmail());
    }

    @Test
    void testSetEmail() {
        client.setEmail("email@email.com");
        assertEquals("email@email.com", client.getEmail());
    }

    @Test
    void testGetPassword() {
        client.setPassword("123456");
        assertEquals("123456", client.getPassword());
    }

    @Test
    void testSetPassword() {
        client.setPassword("123456");
        assertEquals("123456", client.getPassword());
    }

    @Test
    void testGetConfirmPassword() {
        client.setConfirmPassword("123456");
        assertEquals("123456", client.getConfirmPassword());
    }

    @Test
    void testSetConfirmPassword() {
        client.setConfirmPassword("123456");
        assertEquals("123456", client.getConfirmPassword());
    }
}