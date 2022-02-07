package com.bulyginkonstantin.friend_app.controllers;

import com.bulyginkonstantin.friend_app.data.Client;
import com.bulyginkonstantin.friend_app.data.ClientFriendKey;
import com.bulyginkonstantin.friend_app.data.Friend;
import com.bulyginkonstantin.friend_app.repository.FriendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/client")
public class FriendController {


    @Autowired
    FriendsRepository friendsRepository;

    @GetMapping("/addToFriend/{currentId}/{id}")
    public String addFriend(@PathVariable int currentId, @PathVariable int id, Model model) {
        Friend friend = new Friend();
        ClientFriendKey key = new ClientFriendKey(currentId, id);
        friend.setId(key);
        friendsRepository.save(friend);
        Client client = new Client();
        model.addAttribute("client", client);
        model.addAttribute("currentClientId", currentId);
        return "findfriend";
    }


    @GetMapping("/remove/{id}")
    public String remove(@RequestParam("id") int id) {
        return "friends";
    }
}
