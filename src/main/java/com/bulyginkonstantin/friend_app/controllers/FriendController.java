package com.bulyginkonstantin.friend_app.controllers;

import com.bulyginkonstantin.friend_app.data.Client;
import com.bulyginkonstantin.friend_app.data.ClientFriendKey;
import com.bulyginkonstantin.friend_app.data.Friend;
import com.bulyginkonstantin.friend_app.repository.FriendsRepository;
import com.bulyginkonstantin.friend_app.service.ClientService;
import com.bulyginkonstantin.friend_app.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/client")
public class FriendController {

    @Autowired
    ClientService clientService;

    @Autowired
    FriendService friendService;

    @GetMapping("/addToFriend/{currentId}/{id}")
    public String addFriend(@PathVariable int currentId, @PathVariable int id, Model model) {
        //save to database friend entity
        Friend friend = new Friend();
        ClientFriendKey key = new ClientFriendKey(currentId, id);
        friend.setId(key);
        friendService.save(friend);

        //retrieve all friends for current client
        List<Integer> friendsId = friendService.findFriendIdById(currentId);
        List<Client> friends = new ArrayList<>();
        for (Integer i : friendsId) {
            friends.add(clientService.findById(i));
        }
        List<Client> clients = clientService.findAll();
        clients.removeAll(friends);
        model.addAttribute("currentClientId", currentId);
        model.addAttribute("clientsList", clients);
        return "clients";
    }

    @GetMapping("/remove/{id}")
    public String remove(@RequestParam("id") int id) {
        return "friends";
    }
}
