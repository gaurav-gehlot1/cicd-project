package com.example.java.ejb.stateful;

import javax.ejb.Stateful;

@Stateful
public class HelloStateful implements HelloStatefulLocal {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String greet() {
        return "Hello, " + name + " from Stateful EJB!";
    }
}

