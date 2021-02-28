package com.javastudio.shiro.security;

import com.javastudio.shiro.api.dto.User;
import com.javastudio.shiro.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.SimpleByteSource;
import org.slf4j.Logger;

import javax.inject.Inject;

public class PersistenceRealm extends AuthorizingRealm {

    @Inject
    Logger logger;

    @Inject
    private UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (authenticationToken instanceof UsernamePasswordToken) {
            String username = ((UsernamePasswordToken) authenticationToken).getUsername();

            if (username == null) {
                logger.warn("Username is null.");
                return null;
            }

            User user = userService.findByUsername(username);
            if (user == null) {
                logger.warn("No account found for user [{}]", username);
                throw new IncorrectCredentialsException();
            }

            // TODO throw ExpiredCredentialsException if password is expired

            Sha256Hash hashPassword = new org.apache.shiro.crypto.hash.Sha256Hash(((UsernamePasswordToken) authenticationToken).getPassword(), ((UsernamePasswordToken) authenticationToken).getUsername().toLowerCase());
            logger.info("username: {}, password: {}", username, hashPassword);

            return new SimpleAuthenticationInfo(username, hashPassword.toHex(), new SimpleByteSource(/*user.getSalt()*/username), getName());
        }

        throw new AuthenticationException("Invalid credential");
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
