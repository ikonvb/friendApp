package com.bulyginkonstantin.friend_app.repository;

import com.bulyginkonstantin.friend_app.data.Friend;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendsRepository extends CrudRepository<Friend, Integer> {
    @Override
    Iterable<Friend> findAll();
}
