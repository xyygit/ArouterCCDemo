package yann.module_main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;

import yann.module.base.BaseActivity;
import yann.module.base.BaseFragment;
import yann.module.utils.FragmentUtils;
import yann.module.utils.RouteUtils;
import yann.module_main.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.btn_1) {//TODO 简单跳转
            ARouter.getInstance().build(RouteUtils.TEST_COMMON).navigation();
        } else if (i == R.id.btn_2) {//TODO ForResult
            ARouter.getInstance().build(RouteUtils.FORRESULT_TEST).navigation(this, 666);

        } else if (i == R.id.btn_3) {//TODO fragment获取测试
            ARouter.getInstance().build(RouteUtils.HOME_ACTIVITY).navigation();

        } else if (i == R.id.btn_4) {//TODO 携参数应用内跳转
            ARouter.getInstance().build(RouteUtils.TEST_PARAM).withString("name", "老王").withInt("age", 23).navigation();

        } else if (i == R.id.btn_5) {//TODO 跳转动画
            ARouter.getInstance().build(RouteUtils.TEST_COMMON).navigation();

        } else if (i == R.id.btn_6) {//TODO 通过url跳转
            ARouter.getInstance().build(RouteUtils.LOGIN).navigation();

        } else if (i == R.id.btn_7) {//TODO 拦截器测试
            ARouter.getInstance().build(RouteUtils.TEST_LOGIN).navigation();

        } else if (i == R.id.btn_8) {//TODO 依赖注入测试
            BaseFragment baseFragment = FragmentUtils.getInstance().getCenterFragment();
            Log.d("MainActivity",""+baseFragment);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 666:
                Log.e("activityResult", String.valueOf(resultCode));
                break;
            default:
                break;
        }
    }
}
