package com.example.java.ejb.stateless;

import javax.ejb.Stateless;

@Stateless
public class HelloStateless implements HelloStatelessLocal {
    public String sayHello(String name) {
        return "Hello, " + name + " from Stateless EJB!";
    }
}

