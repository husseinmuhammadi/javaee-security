package com.javastudio.shiro.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class LoginController implements Serializable {
    private static final long serialVersionUID = 1982587028476138981L;

    @Inject
    private Logger logger;

    private String username;
    private String password;
    private boolean rememberMe;

    public String login() {
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated())
            return "index?faces-redirect=true";

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(rememberMe);

        try {
            currentUser.login(token);
        } catch (AuthenticationException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid credential", ""));
            return null;
        }

//        SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(null);
//        logger.info("redirecting to " + savedRequest.getRequestURI() + "?faces-redirect=true");

        return "index?faces-redirect=true";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}
