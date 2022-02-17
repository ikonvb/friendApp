package com.bulyginkonstantin.friend_app.controllers;

import com.bulyginkonstantin.friend_app.data.Client;
import com.bulyginkonstantin.friend_app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DeleteController {

    @Autowired
    ClientService clientService;

    @GetMapping("/profile/delete/{currentId}")
    public String deleteProfile(@PathVariable int currentId) {
        Client client = clientService.findById(currentId).get();
        clientService.delete(client);
        return "redirect:/login";
    }
}
