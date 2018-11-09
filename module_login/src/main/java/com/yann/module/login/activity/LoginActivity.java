package com.yann.module.login.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.yann.module.login.R;

import yann.module.base.BaseActionBarActivity;
import yann.module.utils.RouteUtils;

@Route(path = RouteUtils.LOGIN)
public class LoginActivity extends BaseActionBarActivity {
    @Autowired
    String path;

    @Override
    protected int setTitleId() {
        return R.string.app_name;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if(getIntent() != null){
            path = getIntent().getStringExtra("path");
        }
    }

    public void onLogin(View view) {
        if(TextUtils.isEmpty(path)){
            return;
        }
        ARouter.getInstance().build(path).navigation();
    }
}
