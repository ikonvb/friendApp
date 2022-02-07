package com.bulyginkonstantin.friend_app.controllers;

import com.bulyginkonstantin.friend_app.data.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    @GetMapping
    public String login(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "login";
    }
}
