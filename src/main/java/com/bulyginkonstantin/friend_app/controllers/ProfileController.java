package com.bulyginkonstantin.friend_app.controllers;

import com.bulyginkonstantin.friend_app.data.Client;
import com.bulyginkonstantin.friend_app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    ClientService clientService;

    @GetMapping("/showFriends/{id}")
    public String showFriends(Model model) {
        List<Client> friends = clientService.findAll();
        model.addAttribute("friendsList", friends);
        return "friends";
    }

    @GetMapping
    public String showProfile(Client client, Model model) {

        Client loggedClient = clientService.findByLoginAndPassword(client.getLogin(), client.getPassword()).orElse(null);

        if (loggedClient != null) {
            model.addAttribute("client", loggedClient);
            return "profile";
        } else {
            return "login";
        }
    }

    @GetMapping("/findFriend/{id}")
    public String findPerson(@PathVariable int id, Model model) {
        model.addAttribute("currentClientId", id);
        Client client = new Client();
        model.addAttribute("client", client);
        return "findfriend";
    }

}
