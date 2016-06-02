package com.example.mymvp.presenter;

import android.os.Handler;

import com.example.mymvp.model.IUserBiz;
import com.example.mymvp.model.OnLoginListener;
import com.example.mymvp.model.User;
import com.example.mymvp.model.UserBiz;
import com.example.mymvp.view.IUserLoginView;

/**
 * Created by QYer on 2016/6/2.
 */
public class UserLoginPresenter {

    private IUserBiz userBiz;
    private IUserLoginView view;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView view) {

        this.view = view;
        this.userBiz = new UserBiz();
    }

    public void login(){
        //登录前需要view显示loading...
        view.showLoading();
        //真正的登录操作
        userBiz.login(view.getUserName(), view.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
               //登录成功后 自己不操作view 让他自己来
               //回调是在子线程中 切换到主线程中
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        view.toMainActivity(user);
                        view.hideLoading();
                    }
                });

            }

            @Override
            public void loginFailed() {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        view.showFailedError();
                        view.hideLoading();
                    }
                });
            }
        });

    }

    public void clear(){
        view.clearUserName();
        view.clearPassword();
    }

}
