package com.bulyginkonstantin.friend_app.service;

import com.bulyginkonstantin.friend_app.data.Client;
import com.bulyginkonstantin.friend_app.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client registerClient(String login, String userName, String email, String password, String confirmPassword) {
        if (login == null || userName == null || password == null || !password.equalsIgnoreCase(confirmPassword)) {
            return null;
        } else {
            Client client = new Client();
            client.setLogin(login);
            client.setUserName(userName);
            client.setEmail(email);
            client.setPassword(password);
            return clientRepository.save(client);
        }
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public Client loginClient(String login, String password) {
        return clientRepository.findByLoginAndPassword(login, password).orElse(null);
    }

    public Client findByLogin(String login) {
        return clientRepository.findByLogin(login);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public List<Client> findAllByUserName(String userName) {
        return clientRepository.findAllByUserName(userName);
    }

    public Optional<Client> findById(int id) {
        return clientRepository.findById(id);
    }

    public void delete(Client client) {
        clientRepository.delete(client);
    }

    public void deleteById(int id) {
        clientRepository.deleteById(id);
    }


    public Iterable<Client> findAllByOrderByIdAsc() {
        return clientRepository.findAllByOrderByIdAsc();
    }

    public Iterable<Client> findAllWithPageAndSize(Pageable pageSize) {
        return clientRepository.findAll(pageSize);
    }
}
