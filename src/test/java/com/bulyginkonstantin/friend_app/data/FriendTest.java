package com.bulyginkonstantin.friend_app.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FriendTest {

    Friend friend;
    ClientFriendKey clientFriendKey;

    @BeforeEach
    void setUp() {
        friend = new Friend();
        clientFriendKey = new ClientFriendKey();
    }

    @Test
    void getId() {
        clientFriendKey.setClientId(1);
        clientFriendKey.setFriendId(2);
        friend.setId(clientFriendKey);
        assertEquals(clientFriendKey, friend.getId());
    }

    @Test
    void setId() {
        clientFriendKey.setClientId(1);
        clientFriendKey.setFriendId(2);
        friend.setId(clientFriendKey);
        assertEquals(clientFriendKey, friend.getId());
    }
}