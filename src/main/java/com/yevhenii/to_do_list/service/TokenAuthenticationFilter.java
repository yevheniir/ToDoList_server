package com.yevhenii.to_do_list.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import javax.servlet.http.HttpServletRequest;

public class TokenAuthenticationFilter extends AbstractPreAuthenticatedProcessingFilter {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        logger.debug("Retrieving principal from token");
        return request.getHeader("X-Token");
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return request.getHeader("X-Token");
    }


    @Override
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }
}

