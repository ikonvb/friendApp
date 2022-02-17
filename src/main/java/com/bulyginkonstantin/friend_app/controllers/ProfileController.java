package com.bulyginkonstantin.friend_app.controllers;

import com.bulyginkonstantin.friend_app.data.Client;
import com.bulyginkonstantin.friend_app.service.ClientService;
import com.bulyginkonstantin.friend_app.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    FriendService friendService;

    @Autowired
    ClientService clientService;

    //show friends view for current user
    @GetMapping("/showFriends/{currentId}")
    public String showFriends(@PathVariable int currentId, Model model) {
        List<Integer> friendsId = friendService.findFriendIdById(currentId);
        List<Client> friends = new ArrayList<>();
        for (Integer i : friendsId) {
            friends.add(clientService.findById(i).get());
        }
        model.addAttribute("friendsList", friends);
        model.addAttribute("currentClientId", currentId);
        return "friends";
    }

    //show profile view for current user
    @GetMapping("/show/{currentId}")
    public String showProfile(@PathVariable int currentId, Model model) {
        Client loggedClient = clientService.findById(currentId).get();
        model.addAttribute("currentClientId", currentId);
        model.addAttribute("client", loggedClient);
        return "profile";
    }

    //show find friend view for current user
    @GetMapping("/findFriend/{currentId}")
    public String findPerson(@PathVariable int currentId, Model model) {
        Client client = new Client();
        model.addAttribute("currentClientId", currentId);
        model.addAttribute("client", client);
        return "findfriend";
    }

}
