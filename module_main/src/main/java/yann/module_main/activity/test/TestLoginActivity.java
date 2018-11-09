package yann.module_main.activity.test;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.facade.annotation.Route;

import yann.module.base.BaseActionBarActivity;
import yann.module.utils.RouteUtils;
import yann.module_main.R;

/**
 * Created by yayun.xia on 2018/11/9
 */
@Route(path = RouteUtils.TEST_LOGIN)
public class TestLoginActivity extends BaseActionBarActivity {
    @Override
    protected int setTitleId() {
        return R.string.title_test_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(new FrameLayout(this));
    }
}
