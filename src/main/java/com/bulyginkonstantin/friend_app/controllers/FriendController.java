package com.bulyginkonstantin.friend_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/client")
public class FriendController {


    @GetMapping("/addToFriend/{id}")
    public String addFriend(@RequestParam("id") int id) {
        return "friends";
    }

    @GetMapping("/remove/{id}")
    public String remove(@RequestParam("id") int id) {
        return "friends";
    }
}
