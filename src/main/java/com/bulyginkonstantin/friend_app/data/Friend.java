package com.bulyginkonstantin.friend_app.data;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "friends")
public class Friend implements Serializable {
    static final long serialVersionUID = 1L;

    @EmbeddedId
    private ClientFriendKey id;

    public Friend(ClientFriendKey id) {
        this.id = id;
    }

    public Friend() {
    }

    public ClientFriendKey getId() {
        return id;
    }

    public void setId(ClientFriendKey id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Friend friend = (Friend) o;
        return Objects.equals(id, friend.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
