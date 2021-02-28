package com.javastudio.shiro.service;

import com.javastudio.shiro.api.dto.User;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@ApplicationScoped
public class UserService {

    private static final Map<String, User> USERS = new HashMap<>();

    static {
        USERS.put("admin", new User("admin", "ac0e7d037817094e9e0b4441f9bae3209d67b02fa484917065f71b16109a1a78"));
    }

    public User findByUsername(String username) {
        return USERS.get(username);
    }
}
