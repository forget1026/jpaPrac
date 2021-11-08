package com.example.jpa.bookmanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void Test() {
        User user = new User();
        user.setEmail("test@test.com");
        user.setName("ken");

        User user2 = User.builder().name("test").email("test@test.com").build();

        System.out.println(">>> " + user2);
    }
}