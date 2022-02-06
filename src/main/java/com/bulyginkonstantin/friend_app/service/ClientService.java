package com.bulyginkonstantin.friend_app.service;

import com.bulyginkonstantin.friend_app.data.Client;
import com.bulyginkonstantin.friend_app.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Client loginClient(String login, String password) {
        return clientRepository.findByLoginAndPassword(login, password).orElse(null);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> findByLoginAndPassword(String login, String password) {
        return clientRepository.findByLoginAndPassword(login, password);
    }

    public List<Client> findAllByUserName(String userName) {
        return clientRepository.findAllByUserName(userName);
    }

    public Optional<Client> findFirstByLogin(String login) {
        return clientRepository.findFirstByLogin(login);
    }

    public Client findById(int id) {
        return clientRepository.findById(id);
    }

    public void delete(Client client) {
        clientRepository.delete(client);
    }
}
