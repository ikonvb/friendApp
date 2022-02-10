package com.bulyginkonstantin.friend_app.repository;

import com.bulyginkonstantin.friend_app.data.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
@SqlGroup({@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:schema.sql", "classpath:data.sql"}),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:drop.sql")})
class ClientRepositoryTest {

    @Autowired
    ClientRepository clientRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testClientRepositorySize() {
        Client client = new Client();
        client.setId(1);
        client.setLogin("login");
        client.setEmail("test@test.com");
        client.setPassword("123");
        client.setUserName("tester");
        clientRepository.save(client);
        long size = clientRepository.count();
        assertThat(size).isGreaterThan(0);
    }
}