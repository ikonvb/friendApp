package com.bulyginkonstantin.friend_app.controllers;

import com.bulyginkonstantin.friend_app.data.Client;
import com.bulyginkonstantin.friend_app.repository.FriendsRepository;
import com.bulyginkonstantin.friend_app.service.ClientService;
import com.bulyginkonstantin.friend_app.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/find")
public class FindController {

    @Autowired
    FriendService friendService;

    @Autowired
    ClientService clientService;

    //show view to find friend
    @GetMapping("/findFriend/{currentId}")
    public String findPerson(@PathVariable int currentId, Model model) {
        Client client = new Client();
        model.addAttribute("currentClientId", currentId);
        model.addAttribute("client", client);
        return "findfriend";
    }

    //show results of searching
    @PostMapping("/result/{currentId}")
    public String showFindPerson(@PathVariable int currentId, Client client, Model model) {
        List<Integer> friendsId = friendService.findFriendIdById(currentId);
        List<Client> friends = new ArrayList<>();
        for (Integer i : friendsId) {
            friends.add(clientService.findById(i));
        }

        List<Client> clients;
        if (client.getUserName().isEmpty()) {
            clients = clientService.findAll();
        } else {
            clients = clientService.findAllByUserName(client.getUserName());
        }
        clients.removeAll(friends);
        model.addAttribute("currentClientId", currentId);
        model.addAttribute("clientsList", clients);
        return "clients";
    }
}
