package com.bulyginkonstantin.friend_app.service;

import com.bulyginkonstantin.friend_app.data.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
