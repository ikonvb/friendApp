package com.bulyginkonstantin.friend_app.repository;

import com.bulyginkonstantin.friend_app.data.ClientFriendKey;
import com.bulyginkonstantin.friend_app.data.Friend;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendsRepository extends CrudRepository<Friend, ClientFriendKey> {

    @Override
    List<Friend> findAll();

    @Query(value = "SELECT friend_id FROM friends f WHERE f.client_id = ?1", nativeQuery = true)
    List<Integer> findFriendIdById(int id);

}
