package com.example.mymvp.model;

/**
 * Created by QYer on 2016/6/2.
 */
public interface IUserBiz {

    public void login(String username, String password, OnLoginListener loginListener);
}
