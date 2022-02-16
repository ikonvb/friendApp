package com.bulyginkonstantin.friend_app.restapi.controllers;

import com.bulyginkonstantin.friend_app.data.Client;
import com.bulyginkonstantin.friend_app.data.UpdateClient;
import com.bulyginkonstantin.friend_app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/app-api/clients")
public class ClientApiController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public List<Client> getClients() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable("id") int id) {
        return clientService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@Valid @RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Client updateClient(@PathVariable("id") int id, @Valid @RequestBody UpdateClient updateClient) {
        Client cli = clientService.findById(id);
        cli.setLogin(updateClient.getLogin());
        cli.setUserName(updateClient.getUserName());
        cli.setEmail(updateClient.getEmail());
        clientService.saveClient(cli);
        return cli;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable("id") int id) {
        clientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
