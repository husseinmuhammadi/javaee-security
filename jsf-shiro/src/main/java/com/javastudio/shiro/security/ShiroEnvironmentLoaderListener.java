package com.javastudio.shiro.security;

import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.credential.PasswordMatcher;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.env.DefaultWebEnvironment;
import org.apache.shiro.web.env.EnvironmentLoaderListener;
import org.apache.shiro.web.env.WebEnvironment;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.servlet.ServletContext;

public class ShiroEnvironmentLoaderListener extends EnvironmentLoaderListener {
    @Inject
    private Logger logger;

    @Inject
    PersistenceRealm realm;

    @Override
    protected WebEnvironment createEnvironment(ServletContext sc) {
        WebEnvironment env = super.createEnvironment(sc);
        SecurityManager securityManager = env.getSecurityManager();

        if (securityManager instanceof RealmSecurityManager) {
            logger.info("Setting realm with hash algorithm SHA-256");

            CredentialsMatcher credentialsMatcher = new PasswordMatcher();
            // ((PasswordMatcher)credentialsMatcher).setPasswordService();

            realm.setCredentialsMatcher(new HashedCredentialsMatcher("SHA-256"));
            ((RealmSecurityManager) securityManager).setRealm(realm);
        }

        return env;
    }
}
