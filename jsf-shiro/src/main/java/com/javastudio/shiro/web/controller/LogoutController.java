package com.javastudio.shiro.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class LogoutController {

    @Inject
    private Logger logger;

    public String logout() {
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            logger.info("user already logged out!");
            return "index";
        }

        logger.info("try to logout user");
        currentUser.logout();
        return "login";
    }
}
