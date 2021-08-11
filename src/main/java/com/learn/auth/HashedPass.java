package com.learn.auth;

import org.mindrot.jbcrypt.BCrypt;

public class HashedPass {
    public String hashedPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
