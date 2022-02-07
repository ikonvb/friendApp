package com.bulyginkonstantin.friend_app.controllers;

import com.bulyginkonstantin.friend_app.data.Client;
import com.bulyginkonstantin.friend_app.repository.ClientRepository;
import com.bulyginkonstantin.friend_app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/find")
public class FindController {

    @Autowired
    ClientService clientService;

    @GetMapping("/findFriend/{id}")
    public String findPerson(@PathVariable int id, Model model) {
        model.addAttribute("currentClientId", id);
        Client client = new Client();
        model.addAttribute("client", client);
        return "findfriend";
    }

    @PostMapping("/result/{id}")
    public String showFindPerson(@PathVariable int id, Client client, Model model) {

        List<Client> clients;
        if (client.getUserName().isEmpty()) {
            clients = clientService.findAll();
        } else {
            clients = clientService.findAllByUserName(client.getUserName());
        }
        model.addAttribute("currentClientId", id);
        model.addAttribute("clientsList", clients);
        return "clients";
    }
}
