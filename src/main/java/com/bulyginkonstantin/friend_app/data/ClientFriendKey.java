package com.bulyginkonstantin.friend_app.data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ClientFriendKey implements Serializable {

    @Column(name = "client_id")
    private int clientId;

    @Column(name = "friend_id")
    private int friendId;

    public ClientFriendKey(int clientId, int friendId) {
        this.clientId = clientId;
        this.friendId = friendId;
    }

    public ClientFriendKey() {
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientFriendKey that = (ClientFriendKey) o;
        return clientId == that.clientId && friendId == that.friendId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, friendId);
    }
}
