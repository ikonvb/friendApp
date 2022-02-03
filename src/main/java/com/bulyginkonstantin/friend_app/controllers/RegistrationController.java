package com.bulyginkonstantin.friend_app.controllers;

import com.bulyginkonstantin.friend_app.data.Client;
import com.bulyginkonstantin.friend_app.service.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String register(Client client) {
        return "register";
    }


    @PostMapping
    public String register(@Valid Client client, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        if (!client.getPassword().equalsIgnoreCase(client.getConfirmPassword())) {
            model.addAttribute("passNotMatch", "Password do not match");
            return "register";
        }

        client.setPassword(passwordEncoder.encode(client.getPassword()));
        clientRepository.save(client);
        return "redirect:/login";
    }

//    @GetMapping("/registerr")
//    public String register(Model model) {
//        Client client = new Client();
//        model.addAttribute("clientAccount", client);
//        return "registerr";
//    }
//
//    @PostMapping("/registerr/save")
//    public String saveAccount(Model model, Client client) {
//
//        client.setPassword(passwordEncoder.encode(client.getPassword()));
//        clientRepository.save(client);
//        return "redirect:/login";
//    }

}
