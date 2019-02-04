package com.tutorial.spring.services;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("application")
public class Application {
 
    @Resource(name="applicationUser")//autowiring by bean name not type
    private ApplicationUser user;
 
    @Override
    public String toString() {
        return "Application [user=" + user + "]";
    }
}