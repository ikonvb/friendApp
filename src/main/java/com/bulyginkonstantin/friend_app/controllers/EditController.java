package com.bulyginkonstantin.friend_app.controllers;

import com.bulyginkonstantin.friend_app.data.Client;
import com.bulyginkonstantin.dao.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditController {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //register form
    @GetMapping("/edit")
    public String register(Model model) {
        Client client = new Client();
        model.addAttribute("clientAccount", client);
        return "edit";
    }

    //save to DB from register form
    @PostMapping("/edit/save")
    public String saveAccount(Client client) {

        client.setPassword(passwordEncoder.encode(client.getPassword()));
        if (!client.getPassword().equalsIgnoreCase(client.getConfirmPassword())) {
           // model.addAttribute("passNotMatch", "Password do not match");
            return "edit";
        }
        clientRepository.save(client);
        return "redirect:/profile";
    }

}
