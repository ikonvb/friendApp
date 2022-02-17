package com.bulyginkonstantin.friend_app.controllers;

import com.bulyginkonstantin.friend_app.data.Client;
import com.bulyginkonstantin.friend_app.service.ClientService;
import com.bulyginkonstantin.friend_app.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class DeleteController {

    @Autowired
    ClientService clientService;

    @Autowired
    FriendService friendService;

    @GetMapping("/profile/delete/{currentId}")
    public String deleteProfile(@PathVariable int currentId) {
        Client client = clientService.findById(currentId).get();
        clientService.delete(client);
        friendService.deleteAllWhereId(currentId);
        return "redirect:/login";
    }
}
