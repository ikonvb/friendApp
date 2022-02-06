package com.bulyginkonstantin.friend_app.service;

import com.bulyginkonstantin.friend_app.data.Client;
import com.bulyginkonstantin.friend_app.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client registerClient(String login, String email, String password, String confirmPassword) {

        if (login == null || password == null || !password.equalsIgnoreCase(confirmPassword)) {
            return null;
        } else {
            Client client = new Client();
            client.setLogin(login);
            client.setEmail(email);
            client.setPassword(password);
            return clientRepository.save(client);
        }
    }

    public Client loginClient(String login, String password) {
        return clientRepository.findByLoginAndPassword(login, password).orElse(null);
    }

}
