package com.xz2dai;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/**
 * 实现sun.net的代理验证
 *
 */
public class BasicAuthenticator extends Authenticator {
    String userName;
    String password;
    public BasicAuthenticator(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    /**
     * Called when password authorization is needed. Subclasses should override the default implementation, which returns null.
     *
     * @return The PasswordAuthentication collected from the user, or null if none is provided.
     */
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        //System.out.println("DEBUG === use global authentication of password");
        return new PasswordAuthentication(userName, password.toCharArray());
    }
}