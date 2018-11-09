package yann.module_main.activity.test;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;

import yann.module.base.BaseActionBarActivity;
import yann.module.utils.RouteUtils;
import yann.module_main.R;

/**
 * Created by yayun.xia on 2018/11/9
 */
@Route(path = RouteUtils.TEST_PARAM)
public class TestParamActivity extends BaseActionBarActivity {
    @Autowired
    String name;
    @Autowired
    int age;

    private TextView tvParam;

    @Override
    protected int setTitleId() {
        return R.string.title_param_test;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_param_test);

//        String name = getIntent().getStringExtra("name");
//        int age = getIntent().getIntExtra("age", -1);

        tvParam = findViewById(R.id.tv_param);
        tvParam.setText("携带参数--" + "name:" + name + "  age:" + age);
    }
}
