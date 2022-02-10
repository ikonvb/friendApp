package com.bulyginkonstantin.friend_app.repository;

import com.bulyginkonstantin.friend_app.data.ClientFriendKey;
import com.bulyginkonstantin.friend_app.data.Friend;
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
class FriendsRepositoryTest {

    @Autowired
    FriendsRepository friendsRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testFriendsRepository() {
        ClientFriendKey clientFriendKey = new ClientFriendKey(1, 1);
        Friend friend = new Friend(clientFriendKey);
        friendsRepository.save(friend);
        long size = friendsRepository.count();
        assertThat(size).isGreaterThan(0);
    }
}