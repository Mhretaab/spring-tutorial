package com.tutorial.spring.services;

import org.springframework.stereotype.Component;

@Component("applicationUser")
public class ApplicationUser {
 
    private String name = "defaultName";
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    @Override
    public String toString() {
        return "ApplicationUser [name=" + name + "]";
    }
}