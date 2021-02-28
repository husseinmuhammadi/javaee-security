package com.javastudio.shiro.service;

import com.javastudio.shiro.api.dto.User;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class UserServiceTest {

    @Test
    public void findUnregisteredUser() {
        UserService userService = new UserService();
        User user = userService.findByUsername("ad");
        assertNotEquals(user, null);
    }
}