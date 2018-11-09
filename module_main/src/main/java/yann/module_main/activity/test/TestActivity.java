package yann.module_main.activity.test;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;

import yann.module.base.BaseActionBarActivity;
import yann.module.utils.RouteUtils;
import yann.module_main.R;

/**
 * Created by yayun.xia on 2018/11/9
 */
@Route(path = RouteUtils.TEST_COMMON)
public class TestActivity extends BaseActionBarActivity {
    @Override
    protected int setTitleId() {
        return R.string.title_test;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }
}
