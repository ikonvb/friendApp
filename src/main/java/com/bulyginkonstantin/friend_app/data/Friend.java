package com.bulyginkonstantin.friend_app.data;


import javax.persistence.*;

@Entity
@Table(name = "friends_clients")
public class Friend {

    @Id
    @Column(name = "fk_owner_id")
    private int ownerId;

    @Column(name = "fk_client_id")
    private int clientId;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Client getClient() {
        return client;
    }
}
