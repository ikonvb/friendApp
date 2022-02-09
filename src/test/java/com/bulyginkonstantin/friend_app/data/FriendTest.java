package com.bulyginkonstantin.friend_app.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FriendTest {

    Friend friend;
    ClientFriendKey clientFriendKey;

    @BeforeEach
    void setUp() {
        friend = new Friend();
        clientFriendKey = new ClientFriendKey();
    }

    @Test
    void testGetId() {
        clientFriendKey.setClientId(1);
        clientFriendKey.setFriendId(2);
        friend.setId(clientFriendKey);
        assertEquals(clientFriendKey, friend.getId());
    }

    @Test
    void testSetId() {
        clientFriendKey.setClientId(1);
        clientFriendKey.setFriendId(2);
        friend.setId(clientFriendKey);
        assertEquals(clientFriendKey, friend.getId());
    }
}