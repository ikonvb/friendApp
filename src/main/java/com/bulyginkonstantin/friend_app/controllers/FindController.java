package com.bulyginkonstantin.friend_app.controllers;

import com.bulyginkonstantin.friend_app.data.Client;
import com.bulyginkonstantin.friend_app.repository.ClientRepository;
import com.bulyginkonstantin.friend_app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/findFriends")
public class FindController {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientService clientService;

    @GetMapping
    public String findPerson() {
        return "findfriend";
    }

    @PostMapping("/result")
    public String showFindPerson(Client client, Model model) {

        List<Client> clients;

        if (client.getUserName().isEmpty()) {
            clients = clientService.findAll();
        } else {
            clients = clientService.findAllByUserName(client.getUserName());
        }
        model.addAttribute("clientsList", clients);
        return "clients";

    }
}
