package com.javastudio.shiro.security;

import com.javastudio.shiro.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.SimpleByteSource;

import javax.inject.Inject;

public class DatabaseRealm extends AuthorizingRealm {

    @Inject
    private UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (authenticationToken instanceof UsernamePasswordToken) {
            String username = ((UsernamePasswordToken) authenticationToken).getUsername();
            Sha256Hash hashPassword = new org.apache.shiro.crypto.hash.Sha256Hash(((UsernamePasswordToken) authenticationToken).getPassword(), ((UsernamePasswordToken) authenticationToken).getUsername().toLowerCase());

            return new SimpleAuthenticationInfo(user.getUsername(), hashPassword.toHex(), new SimpleByteSource(user.getSalt()), getName());
        }

        throw new AuthenticationException("Invalid credential");
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
