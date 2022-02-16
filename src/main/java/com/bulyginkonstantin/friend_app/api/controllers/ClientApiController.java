package com.bulyginkonstantin.friend_app.api.controllers;

import com.bulyginkonstantin.friend_app.data.Client;
import com.bulyginkonstantin.friend_app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app-api/clients")
public class ClientApiController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public List<Client> getClients() {
        return clientService.findAll();
    }
}
