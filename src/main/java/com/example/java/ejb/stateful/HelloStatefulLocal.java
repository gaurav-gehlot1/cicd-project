package com.example.java.ejb.stateful;

import javax.ejb.Local;

@Local
public interface HelloStatefulLocal {
    void setName(String name);
    String greet();
}

