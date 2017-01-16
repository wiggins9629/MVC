package com.wiggins.mvc.model;


import com.wiggins.mvc.listener.OnLoginListener;

/**
 * @Description 登录操作接口
 * @Author 一花一世界
 * @Time 2017/1/14 16:01
 */

public interface LoginModel {

    void getLoginInfo(String name, String password, OnLoginListener onLoginListener);
}
