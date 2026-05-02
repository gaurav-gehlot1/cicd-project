package com.example.java.ejb.stateless;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class StatelessClient {
    public static void main(String[] args) {
        try {
            Properties props = new Properties();
            props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
            props.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
            Context context = new InitialContext(props);

            HelloStatelessLocal bean = (HelloStatelessLocal) context.lookup(
                "java:global/cicd-project/HelloStateless!com.example.java.ejb.stateless.HelloStatelessLocal"
            );

            System.out.println(bean.sayHello("Alice"));
        } catch (NamingException e) {
            System.out.println("Stateless EJB Client (simulated): Hello, Alice from Stateless EJB!");
        }
    }
}

