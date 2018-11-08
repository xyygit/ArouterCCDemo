package com.yann.module.usercenter;

import android.os.Bundle;

import yann.module.base.BaseActionBarActivity;

public class UserCenterActivity extends BaseActionBarActivity {

    @Override
    protected int setTitleId() {
        return R.string.app_name;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_center);
    }
}
