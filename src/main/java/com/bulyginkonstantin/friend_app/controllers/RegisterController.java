package com.bulyginkonstantin.friend_app.controllers;

import com.bulyginkonstantin.friend_app.data.Client;
import com.bulyginkonstantin.friend_app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    ClientService clientService;

    //register form
    @GetMapping("/new")
    public String register(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "register";
    }

    //save to DB from register form
    @PostMapping("/save")
    public String saveAccount(@Valid @ModelAttribute Client client, Errors errors) {
        if (errors.hasErrors()) {
            return "register";
        }

        clientService.registerClient(
                client.getLogin(),
                client.getUserName(),
                client.getEmail(),
                client.getPassword(),
                client.getConfirmPassword());
        return "login";
    }
}
