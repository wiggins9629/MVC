package com.wiggins.mvc.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wiggins.mvc.R;
import com.wiggins.mvc.listener.OnLoginListener;
import com.wiggins.mvc.model.LoginModel;
import com.wiggins.mvc.model.imple.LoginModelImple;

/**
 * @Description mvc登录案例
 * @Author 一花一世界
 * @Time 2017/1/14 16:11
 */

public class LoginActivity extends Activity implements View.OnClickListener {

    private LoginActivity mActivity = null;
    private EditText mEdtName;
    private EditText mEdtPwd;
    private Button mBtnLogin;

    private LoginModel loginModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mActivity = this;
        loginModel = new LoginModelImple();

        initView();
        setListener();
    }

    private void initView() {
        mEdtName = (EditText) findViewById(R.id.edt_name);
        mEdtPwd = (EditText) findViewById(R.id.edt_pwd);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
    }

    private void setListener() {
        mBtnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                String name = mEdtName.getText().toString().trim();
                String pwd = mEdtPwd.getText().toString().trim();
                loginModel.getLoginInfo(name, pwd, new OnLoginListener() {
                    @Override
                    public void onUsernameEmpty() {
                        showToast(getResources().getString(R.string.name_not_empty));
                    }

                    @Override
                    public void onPasswordEmpty() {
                        showToast(getResources().getString(R.string.password_not_empty));
                    }

                    @Override
                    public void onUsernameError() {
                        showToast(getResources().getString(R.string.name_error));
                    }

                    @Override
                    public void onPasswordError() {
                        showToast(getResources().getString(R.string.password_error));
                    }

                    @Override
                    public void onSuccess() {
                        showToast(getResources().getString(R.string.login_successful));
                        Intent intent = new Intent(mActivity, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void onFailure() {
                        showToast(getResources().getString(R.string.login_failed));
                    }
                });
                break;
        }
    }

    private void showToast(String msg) {
        Toast.makeText(mActivity, msg, Toast.LENGTH_LONG).show();
    }
}
