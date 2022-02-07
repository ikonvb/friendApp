package com.bulyginkonstantin.friend_app.repository;

import com.bulyginkonstantin.friend_app.data.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ClientRepositoryTest {

    @Autowired
    ClientRepository clientRepository;

    @Test
    public void testClientRepository() {
        Client client = new Client();
        clientRepository.save(client);
        long size = clientRepository.count();
        assertThat(size).isGreaterThan(0);
    }


}