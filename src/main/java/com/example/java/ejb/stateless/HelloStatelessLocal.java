package com.example.java.ejb.stateless;

import javax.ejb.Local;

@Local
public interface HelloStatelessLocal {
    String sayHello(String name);
}

