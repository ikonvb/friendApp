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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/client")
public class FriendController {

    @Autowired
    ClientService clientService;


    @Autowired
    FriendsRepository friendsRepository;

    @GetMapping("/addToFriend/{currentId}/{id}")
    public String addFriend(@PathVariable int currentId, @PathVariable int id, Model model) {

        //start-> save to database friend entity
        Friend friend = new Friend();
        ClientFriendKey key = new ClientFriendKey(currentId, id);
        friend.setId(key);
        friendsRepository.save(friend);
        //<-end

        //start-> retrieve all friends for current client
        List<Integer> friendsId = friendsRepository.findFriendIdById(currentId);
        List<Client> friends = new ArrayList<>();
        for (Integer i : friendsId) {
            friends.add(clientService.findById(i));
        }
        //<-end

        List<Client> clients = clientService.findAll();
        List<Client> noFriends = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < clients.size(); j++) {
                if (Objects.equals(friends.get(i).getId(), clients.get(j).getId())) {
                    continue;
                } else {
                    noFriends.add(clients.get(j));
                }
            }
        }

//        Iterator<Client> clientIterator = clients.iterator();
//        for (Client client : friends) {
//            if (client.getId().equals(clientIterator.next().getId())) {
//                clientIterator.remove();
//            }
//        }

        System.out.println("Clients =: " + clients.size());
        System.out.println("Friends =: " + friends.size());
        System.out.println("No friends =: " + noFriends.size());


        model.addAttribute("currentClientId", currentId);
        model.addAttribute("clientsList", noFriends);
        return "clients";
    }


    @GetMapping("/remove/{id}")
    public String remove(@RequestParam("id") int id) {
        return "friends";
    }
}
