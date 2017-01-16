package com.wiggins.mvc.listener;

/**
 * @Description 登录状态监听器
 * @Author 一花一世界
 * @Time 2017/1/14 16:07
 */

public interface OnLoginListener {


    void onUsernameEmpty();

    void onPasswordEmpty();

    void onUsernameError();

    void onPasswordError();

    void onSuccess();

    void onFailure();
}
