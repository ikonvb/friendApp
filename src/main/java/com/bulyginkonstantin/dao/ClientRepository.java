package com.bulyginkonstantin.dao;

import com.bulyginkonstantin.friend_app.data.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
