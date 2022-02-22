package com.bulyginkonstantin.friend_app.restapi.controllers;

import com.bulyginkonstantin.friend_app.data.*;
import com.bulyginkonstantin.friend_app.service.ClientService;
import com.bulyginkonstantin.friend_app.service.FriendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
@Api("Main controller to handle client endpoints")
public class ClientApiController {

    @Autowired
    ClientService clientService;

    @Autowired
    FriendService friendService;

    //add to friend
    @GetMapping("/{currentId}/addToFriend/{id}")
    @ApiOperation("Add one registered user to a friend for the current user and return list of all friends for current user")
    public ResponseEntity<List<Client>> addFriend(@PathVariable int currentId, @PathVariable int id) {
        Friend friend = new Friend();
        ClientFriendKey key = new ClientFriendKey(currentId, id);
        friend.setId(key);
        friendService.save(friend);
        //retrieve all friends for current client
        List<Client> friends = getClients(currentId);
        return new ResponseEntity<>(friends, HttpStatus.OK);
    }

    //show remaining clients for current user to add to friends
    @GetMapping("/{currentId}/find/all")
    @ApiOperation("Returns list of all users available to add to a friend for current user")
    public ResponseEntity<List<Client>> findClientsForRegisteredUser(@PathVariable int currentId) {
        //retrieve all friends for current client
        List<Client> friends = getClients(currentId);
        friends.add(clientService.findById(currentId).get());
        //retrieve all clients for current client
        List<Client> clients = clientService.findAll();
        //delete all clients who are already friends
        clients.removeAll(friends);
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/{currentId}/findByUserName/{userName}")
    @ApiOperation("Returns list of registered users or one user with requested name available to add to a friend")
    public ResponseEntity<List<Client>> findClientByName(@PathVariable int currentId, @PathVariable String userName) {
        List<Client> friends = getClients(currentId);
        friends.add(clientService.findById(currentId).get());
        List<Client> clients = clientService.findAllByUserName(userName);
        clients.removeAll(friends);
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    //delete friend
    @GetMapping("/{currentId}/remove/{id}")
    @ApiOperation("Delete one friend from friends list for current user and returns list of remain friends")
    public ResponseEntity<List<Client>> remove(@PathVariable int currentId, @PathVariable int id) {
        //delete friend for current client
        ClientFriendKey key = new ClientFriendKey(currentId, id);
        Friend friend = new Friend(key);
        friendService.delete(friend);
        List<Client> friends = getClients(currentId);
        return new ResponseEntity<>(friends, HttpStatus.OK);
    }

    //show friends for current user
    @GetMapping("/{currentId}/showFriends")
    @ApiOperation("Returns list of all friends for current user")
    public ResponseEntity<List<Client>> showFriend(@PathVariable int currentId) {
        //retrieve all friends for current client
        List<Client> friends = getClients(currentId);
        return new ResponseEntity<>(friends, HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Delete one registered user by id and returns http status 204 no content")
    public void deleteClient(@PathVariable("id") int id) {
        try {
            Client client = clientService.findById(id).get();
            friendService.deleteAllWhereId(id);
            clientService.deleteById(id);
        } catch (EmptyResultDataAccessException err) {
            err.printStackTrace();
        }
    }

    @PatchMapping(path = "/edit/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Edit registered user by id and returns edited user")
    public ResponseEntity<Client> updateClient(@PathVariable("id") int id, @Valid @RequestBody UpdateClient updateClient) {
        Optional<Client> optCli = clientService.findById(id);
        if (optCli.isPresent()) {
            optCli.get().setLogin(updateClient.getLogin());
            optCli.get().setUserName(updateClient.getUserName());
            optCli.get().setEmail(updateClient.getEmail());
            clientService.saveClient(optCli.get());
            return new ResponseEntity<>(optCli.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Login registered user and returns user")
    public ResponseEntity<Client> loginClient(@Valid @RequestBody LoginClient loginClient) {
        Client client = clientService.loginClient(loginClient.getLogin(), loginClient.getPassword());
        if (client == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Register new user and returns registered user if user with the same login exists returns HttpStatus 400")
    public ResponseEntity<Client> createClient(@Valid @RequestBody Client client) {
        Client regClient = clientService.findByLogin(client.getLogin());
        if (regClient == null) {
            clientService.saveClient(client);
            return new ResponseEntity<>(client, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
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
