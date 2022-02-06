package com.bulyginkonstantin.friend_app.controllers;

import com.bulyginkonstantin.friend_app.data.Client;
import com.bulyginkonstantin.friend_app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public String login(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "login";
    }

    @PostMapping
    public String login(@ModelAttribute Client client, Model model) {

        Client loggedClient = clientService.loginClient(client.getLogin(), client.getPassword());

        if (loggedClient != null) {
            model.addAttribute("clientAccount", loggedClient);
            return "profile";
        } else {
            return "login";
        }
    }
}
