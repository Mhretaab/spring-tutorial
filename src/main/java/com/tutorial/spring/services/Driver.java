package com.tutorial.spring.services;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 
@Component("driver")
public class Driver {

    //@Autowired
    private License license;
     
    @Autowired //inject by type
    public Driver(License license){
        this.license = license;
    }
     
    @Override
    public String toString() {
        return "Driver [license=" + license + "]";
    }
}