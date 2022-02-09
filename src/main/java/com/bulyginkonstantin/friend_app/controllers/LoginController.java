package com.bulyginkonstantin.friend_app.controllers;

import com.bulyginkonstantin.friend_app.data.Client;
import com.bulyginkonstantin.friend_app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public String logout(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "login";
    }

    @PostMapping
    public String login(Client client, Model model) {
        String login = client.getLogin();
        String password = client.getPassword();
        if (login.isEmpty()) {
            model.addAttribute("errorLogin", "Please enter login");
            return "login";
        }
        if (password.isEmpty()) {
            model.addAttribute("errorPassword", "Please enter password");
            return "login";
        }
        Client loggedClient = clientService.loginClient(login, password);
        if (loggedClient != null) {
            model.addAttribute("client", loggedClient);
            return "profile";
        } else {
            model.addAttribute("error", "You don`t have an account");
            return "login";
        }
    }
}
