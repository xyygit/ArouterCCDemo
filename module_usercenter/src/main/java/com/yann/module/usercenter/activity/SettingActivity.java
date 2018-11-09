package com.yann.module.usercenter.activity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yann.module.usercenter.R;

import yann.module.base.BaseActionBarActivity;
import yann.module.utils.RouteUtils;

/**
 * Created by yayun.xia on 2018/11/9
 */
@Route(path = RouteUtils.CENTER_SETTING,group = "center")
public class SettingActivity extends BaseActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

    @Override
    protected int setTitleId() {
        return R.string.setting_title;
    }
}
