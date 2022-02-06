package com.bulyginkonstantin.friend_app.controllers;

import com.bulyginkonstantin.friend_app.data.Client;
import com.bulyginkonstantin.friend_app.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeleteController {

    @Autowired
    ClientRepository clientRepository;

    @GetMapping
    public String delete(Client client) {
        clientRepository.delete(client);
        return "redirect:/login";
    }
}
