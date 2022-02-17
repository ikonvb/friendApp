package com.bulyginkonstantin.friend_app.repository;

import com.bulyginkonstantin.friend_app.data.ClientFriendKey;
import com.bulyginkonstantin.friend_app.data.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface FriendsRepository extends JpaRepository<Friend, ClientFriendKey> {

    @Override
    List<Friend> findAll();

    @Query(value = "SELECT friend_id FROM friends f WHERE f.client_id = ?1", nativeQuery = true)
    List<Integer> findFriendIdById(int id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM friends f WHERE f.client_id = ?1 OR f.friend_id = ?1", nativeQuery = true)
    void deleteAllWhereId(int id);
}