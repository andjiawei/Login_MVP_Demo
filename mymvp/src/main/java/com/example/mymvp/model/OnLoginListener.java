package com.example.mymvp.model;

/**
 * Created by QYer on 2016/6/2.
 *
 * 登录的监听 成功后有参数 等会用到
 *
 */
public interface OnLoginListener {


    void loginSuccess(User user);//参数看怎么设计

    void loginFailed();


}
