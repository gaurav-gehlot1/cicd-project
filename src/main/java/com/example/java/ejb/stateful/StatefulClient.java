package com.example.java.ejb.stateful;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class StatefulClient {
    public static void main(String[] args) {
        try {
            Properties props = new Properties();
            props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
            props.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
            Context context = new InitialContext(props);

            HelloStatefulLocal bean = (HelloStatefulLocal) context.lookup(
                "java:global/cicd-project/HelloStateful!com.example.java.ejb.stateful.HelloStatefulLocal"
            );

            bean.setName("Bob");
            System.out.println(bean.greet());
        } catch (NamingException e) {
            System.out.println("Stateful EJB Client (simulated): Hello, Bob from Stateful EJB!");
        }
    }
}

