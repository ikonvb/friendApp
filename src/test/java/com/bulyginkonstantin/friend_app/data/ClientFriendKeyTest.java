package com.bulyginkonstantin.friend_app.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ClientFriendKeyTest {

    ClientFriendKey clientFriendKey;

    @BeforeEach
    void setUp() {
        clientFriendKey = new ClientFriendKey(1, 2);
    }

    @Test
    void getClientId() {
        int id = clientFriendKey.getClientId();
        assertEquals(1, id);
    }

    @Test
    void setClientId() {
        clientFriendKey.setClientId(5);
        assertEquals(5, clientFriendKey.getClientId());
    }

    @Test
    void getFriendId() {
        int id = clientFriendKey.getFriendId();
        assertEquals(2, id);
    }

    @Test
    void setFriendId() {
        clientFriendKey.setFriendId(5);
        assertEquals(5, clientFriendKey.getFriendId());
    }
}