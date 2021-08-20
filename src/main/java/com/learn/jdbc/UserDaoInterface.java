package com.learn.jdbc;

import com.learn.entity.User;

public interface UserDaoInterface {

    public int registerUser(User user);

    public User getUser(String email, String pwd);

    public boolean checkLogin(String email, String pwd);

}
