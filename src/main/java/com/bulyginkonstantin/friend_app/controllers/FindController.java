package com.bulyginkonstantin.friend_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FindController {

    @GetMapping("/find")
    public String findPerson() {
        return "findfriend";
    }
}
