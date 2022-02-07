package com.bulyginkonstantin.friend_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class FriendAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FriendAppApplication.class, args);
    }

}
