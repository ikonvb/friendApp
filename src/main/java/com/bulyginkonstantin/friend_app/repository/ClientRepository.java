package com.bulyginkonstantin.friend_app.repository;

import com.bulyginkonstantin.friend_app.data.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

    @Override
    List<Client> findAll();

    Optional<Client> findByLoginAndPassword(String login, String password);

    List<Client> findAllByUserName(String userName);

    Client findById(int clientId);

}
