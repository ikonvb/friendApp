package com.bulyginkonstantin.friend_app.service;

import com.bulyginkonstantin.friend_app.data.Friend;
import com.bulyginkonstantin.friend_app.repository.FriendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {

    @Autowired
    FriendsRepository friendsRepository;

    public List<Integer> findFriendIdById(int currentId) {
        return friendsRepository.findFriendIdById(currentId);
    }

    public void save(Friend friend) {
        friendsRepository.save(friend);
    }

    public void delete(Friend friend) {
        friendsRepository.delete(friend);
    }
}
