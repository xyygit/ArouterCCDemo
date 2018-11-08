package com.yann.module.login;

import android.os.Bundle;

import yann.module.base.BaseActionBarActivity;

public class LoginActivity extends BaseActionBarActivity {

    @Override
    protected int setTitleId() {
        return R.string.app_name;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
