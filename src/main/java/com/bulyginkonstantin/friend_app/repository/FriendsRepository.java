package com.bulyginkonstantin.friend_app.repository;

import com.bulyginkonstantin.friend_app.data.Friend;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendsRepository extends CrudRepository<Friend, Integer> {

    @Override
    List<Friend> findAll();
}
