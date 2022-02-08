package com.bulyginkonstantin.friend_app.repository;

import com.bulyginkonstantin.friend_app.data.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

    @Override
    List<Client> findAll();

    Optional<Client> findByLoginAndPassword(String login, String password);

    Optional<Client> findFirstByLogin(String login);

    List<Client> findAllByUserName(String userName);

    Client findById(int clientId);

    @Query(value = "SELECT * FROM clients c WHERE c.id != ?1", nativeQuery = true)
    Client findClientByExcludedId(int id);
}
