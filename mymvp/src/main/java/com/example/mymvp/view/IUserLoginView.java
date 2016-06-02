package com.example.mymvp.view;

import com.example.mymvp.model.User;

/**
 * Created by QYer on 2016/6/2.
 */
public interface IUserLoginView {

    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();

}
