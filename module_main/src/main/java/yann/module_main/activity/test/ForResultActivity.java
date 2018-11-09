package yann.module_main.activity.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;

import yann.module.base.BaseActionBarActivity;
import yann.module.utils.RouteUtils;
import yann.module_main.R;

/**
 * Created by yayun.xia on 2018/11/9
 */
@Route(path = RouteUtils.FORRESULT_TEST)
public class ForResultActivity extends BaseActionBarActivity {
    @Override
    protected int setTitleId() {
        return R.string.title_forresult;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forresult_test);
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("name", "ForResult返回的数据");
        setResult(999, intent);
        finish();
    }
}
