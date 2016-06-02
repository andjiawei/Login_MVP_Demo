package com.example.mymvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mymvp.model.User;
import com.example.mymvp.presenter.UserLoginPresenter;
import com.example.mymvp.view.IUserLoginView;

public class MainActivity extends AppCompatActivity implements IUserLoginView {


    private EditText mEtUsername, mEtPassword;
    private Button mBtnLogin, mBtnClear;
    private ProgressBar mPbLoading;

    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //建bean 得到用户输入 联网登录 监听登录状态 做相应操作
        initViews();
    }

    private void initViews()
    {
        mEtUsername = (EditText) findViewById(R.id.id_et_username);
        mEtPassword = (EditText) findViewById(R.id.id_et_password);

        mBtnClear = (Button) findViewById(R.id.id_btn_clear);
        mBtnLogin = (Button) findViewById(R.id.id_btn_login);

        mPbLoading = (ProgressBar) findViewById(R.id.id_pb_loading);

        mBtnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mUserLoginPresenter.login();//登录操作交给P层处理
            }
        });

        mBtnClear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mUserLoginPresenter.clear();//登录操作交给P层处理
            }
        });
    }

    @Override
    public String getUserName() {
        return mEtUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return mEtPassword.getText().toString();
    }

    @Override
    public void clearUserName() {
        mEtUsername.setText("");
    }

    @Override
    public void clearPassword() {
        mEtPassword.setText("");
    }

    @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this,user.getUsername()+"",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,"showFailedError",Toast.LENGTH_SHORT).show();
    }
}
