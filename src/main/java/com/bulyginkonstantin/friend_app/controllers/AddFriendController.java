package com.bulyginkonstantin.friend_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddFriendController {

    @GetMapping("/client/addToFriend")
    public String addFriend(@RequestParam("id") int clientId) {

        return "friends";
    }
}
