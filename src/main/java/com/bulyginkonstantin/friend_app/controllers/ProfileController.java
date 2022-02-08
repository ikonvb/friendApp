package com.bulyginkonstantin.friend_app.controllers;

import com.bulyginkonstantin.friend_app.data.Client;
import com.bulyginkonstantin.friend_app.data.ClientFriendKey;
import com.bulyginkonstantin.friend_app.data.Friend;
import com.bulyginkonstantin.friend_app.repository.FriendsRepository;
import com.bulyginkonstantin.friend_app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    FriendsRepository friendsRepository;
    @Autowired
    ClientService clientService;

    //show friends view for current user
    @GetMapping("/showFriends/{id}")
    public String showFriends(@PathVariable int id, Model model) {
        model.addAttribute("currentClientId", id);

        List<Integer> friendsId = friendsRepository.findFriendIdById(id);
        List<Client> friends = new ArrayList<>();
        for(Integer i: friendsId) {
            friends.add(clientService.findById(i));
        }
        model.addAttribute("friendsList", friends);
        return "friends";
    }

    //show profile view for current user
    @GetMapping("/show/{id}")
    public String showProfile(@PathVariable int id, Client client, Model model) {
        model.addAttribute("currentClientId", id);
        Client loggedClient = clientService.findById(id);
        model.addAttribute("client", loggedClient);
        return "profile";
    }

    //show find friend view for current user
    @GetMapping("/findFriend/{id}")
    public String findPerson(@PathVariable int id, Model model) {
        model.addAttribute("currentClientId", id);
        Client client = new Client();
        model.addAttribute("client", client);
        return "findfriend";
    }

}
