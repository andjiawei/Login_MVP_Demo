package com.example.mymvp.model;

/**
 * Created by QYer on 2016/6/2.
 */
public class UserBiz implements IUserBiz {

    //让用户执行登陆 让model和数据直接联系
    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {

        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("zjw".equals(username) && "123".equals(password))
                {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                } else
                {
                    loginListener.loginFailed();
                }
            }
        }.start();

    }
}
