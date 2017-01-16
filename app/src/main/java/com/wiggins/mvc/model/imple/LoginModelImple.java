package com.wiggins.mvc.model.imple;


import com.wiggins.mvc.listener.OnLoginListener;
import com.wiggins.mvc.model.LoginModel;
import com.wiggins.mvc.utils.NetworkUtils;

/**
 * @Description 登录操作接口实现，这里主要是业务逻辑操作
 * @Author 一花一世界
 * @Time 2017/1/14 16:03
 */
public class LoginModelImple implements LoginModel {

    @Override
    public void getLoginInfo(String name, String password, final OnLoginListener onLoginListener) {
        if (name.isEmpty()) {
            onLoginListener.onUsernameEmpty();
        } else if (password.isEmpty()) {
            onLoginListener.onPasswordEmpty();
        } else if (!name.equals("admin")) {
            onLoginListener.onUsernameError();
        } else if (!password.equals("123456")) {
            onLoginListener.onPasswordError();
        } else if (!NetworkUtils.isNetworkAvailable()) {
            onLoginListener.onFailure();
        } else {
            onLoginListener.onSuccess();
        }
    }
}
