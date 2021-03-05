package com.javastudio.shiro.web.controller;

import com.javastudio.shiro.api.dto.User;
import com.javastudio.shiro.service.UserService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.RequestCookieMap;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class UserController {
    private String username;
    private String password;

    @Inject
    private Logger logger;

    @Inject
    private UserService userService;

}
