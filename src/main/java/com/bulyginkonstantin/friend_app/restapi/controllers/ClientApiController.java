package com.bulyginkonstantin.friend_app.restapi.controllers;

import com.bulyginkonstantin.friend_app.data.Client;
import com.bulyginkonstantin.friend_app.data.LoginClient;
import com.bulyginkonstantin.friend_app.data.UpdateClient;
import com.bulyginkonstantin.friend_app.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/clients", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class ClientApiController {

    @Autowired
    ClientService clientService;

    @GetMapping(path = "/all")
    public Iterable<Client> getClients() {
        return clientService.findAllByOrderByIdAsc();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable int id) {
        Optional<Client> client = clientService.findById(id);
        return client.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @GetMapping("/findByUserName/{userName}")
    public ResponseEntity<List<Client>> getClientByName(@PathVariable String userName) {
        List<Client> clients = clientService.findAllByUserName(userName);
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@Valid @RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Client loginClient(@Valid @RequestBody LoginClient loginClient) {
        return clientService.loginClient(loginClient.getLogin(), loginClient.getPassword());
    }

    @PatchMapping(path = "/edit/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
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

    @DeleteMapping(path = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable("id") int id) {
        try {
            clientService.deleteById(id);
        } catch (EmptyResultDataAccessException err) {
            err.printStackTrace();
        }
    }

    @GetMapping(path = "/all", params = {"page", "size"})
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Client> findPaginationClient(@RequestParam int page, @RequestParam int size) {
        Pageable pageSize = PageRequest.of(page, size);
        return clientService.findAllWithPageAndSize(pageSize);
    }

}
