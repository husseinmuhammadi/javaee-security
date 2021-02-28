package com.javastudio.shiro.web.listener;

import org.apache.shiro.web.env.DefaultWebEnvironment;
import org.apache.shiro.web.env.EnvironmentLoaderListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

// Already configured in web.xml
//@WebListener
public class ShiroListener extends EnvironmentLoaderListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // It is used to define the WebEnvironment implementation class to use in the servlet context.
        sce.getServletContext().setInitParameter(ENVIRONMENT_CLASS_PARAM, DefaultWebEnvironment.class.getName());
        super.contextInitialized(sce);
    }
}
