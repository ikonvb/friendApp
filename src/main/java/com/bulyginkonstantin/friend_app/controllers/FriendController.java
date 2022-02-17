package com.bulyginkonstantin.friend_app.controllers;

import com.bulyginkonstantin.friend_app.data.Client;
import com.bulyginkonstantin.friend_app.data.ClientFriendKey;
import com.bulyginkonstantin.friend_app.data.Friend;
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
@RequestMapping("/client")
public class FriendController {

    @Autowired
    ClientService clientService;

    @Autowired
    FriendService friendService;

    //save friend
    @GetMapping("/addToFriend/{currentId}/{id}")
    public String addFriend(@PathVariable int currentId, @PathVariable int id, Model model) {
        //save to database friend entity
        Friend friend = new Friend();
        ClientFriendKey key = new ClientFriendKey(currentId, id);
        friend.setId(key);
        friendService.save(friend);

        //retrieve all friends for current client
        List<Client> friends = getClients(currentId);
        //retrieve all clients for current client
        List<Client> clients = clientService.findAll();
        //delete all clients who are already friends
        clients.removeAll(friends);
        model.addAttribute("currentClientId", currentId);
        model.addAttribute("clientsList", clients);
        return "clients";
    }

    //delete friend
    @GetMapping("/remove/{currentId}/{id}")
    public String remove(@PathVariable int currentId, @PathVariable int id, Model model) {

        //delete friend for current client
        ClientFriendKey key = new ClientFriendKey(currentId, id);
        Friend friend = new Friend(key);
        friendService.delete(friend);

        List<Client> friends = getClients(currentId);
        model.addAttribute("currentClientId", currentId);
        model.addAttribute("friendsList", friends);
        return "friends";
    }

    private List<Client> getClients(int currentId) {
        List<Integer> friendsId = friendService.findFriendIdById(currentId);
        List<Client> friends = new ArrayList<>();
        for (Integer i : friendsId) {
            friends.add(clientService.findById(i).get());
        }
        return friends;
    }
}
