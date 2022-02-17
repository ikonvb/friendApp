package com.bulyginkonstantin.friend_app.repository;

import com.bulyginkonstantin.friend_app.data.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Override
    List<Client> findAll();

    Iterable<Client> findAllByOrderByIdAsc();

    Optional<Client> findByLoginAndPassword(String login, String password);

    List<Client> findAllByUserName(String userName);

    Optional<Client> findById(int clientId);

}
