package com.codegym.task.task37.task3709.connectors;

import com.codegym.task.task37.task3709.security.SecurityChecker;
import com.codegym.task.task37.task3709.security.SecurityCheckerImpl;

public class SecurityProxyConnector implements Connector {


    //fields
    private SimpleConnector simpleConnector;
    private SecurityChecker securityChecker;

    //constr
    public SecurityProxyConnector(String resourceString) {
        simpleConnector = new SimpleConnector(resourceString);
        securityChecker = new SecurityCheckerImpl();
    }



    @Override
    public void connect() {

        if (securityChecker.performSecurityCheck()) {
            simpleConnector.connect();
        }

    }
}