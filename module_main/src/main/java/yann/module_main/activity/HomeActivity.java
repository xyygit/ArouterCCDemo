package yann.module_main.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.alibaba.android.arouter.facade.annotation.Route;

import java.util.ArrayList;
import java.util.List;

import yann.module.base.BaseActivity;
import yann.module.base.BaseFragment;
import yann.module.utils.FragmentUtils;
import yann.module.utils.RouteUtils;
import yann.module.widget.NoScrollViewPager;
import yann.module_main.R;
import yann.module_main.adapter.FragmentAdapter;

/**
 * Created by yayun.xia on 2018/11/9
 */
@Route(path = RouteUtils.HOME_ACTIVITY)
public class HomeActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private NoScrollViewPager mPager;
    private List<BaseFragment> mFragments;
    private FragmentAdapter mAdapter;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mPager = findViewById(R.id.vp_home);
        bottomNavigationView = findViewById(R.id.navi_home);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        initView();
    }

    private void initView() {
        mFragments = new ArrayList<>(4);
        mFragments.add(FragmentUtils.getInstance().getHomeFragment());
        mFragments.add(FragmentUtils.getInstance().getCategoryFragment());
        mFragments.add(FragmentUtils.getInstance().getCartFragment());
        mFragments.add(FragmentUtils.getInstance().getCenterFragment());

        mAdapter = new FragmentAdapter(getSupportFragmentManager(), mFragments);
        mPager.setPagerEnabled(false);
        mPager.setAdapter(mAdapter);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int i = menuItem.getItemId();
        if (i == R.id.navigation_home) {
            mPager.setCurrentItem(0);
            return true;
        } else if (i == R.id.navigation_category) {
            mPager.setCurrentItem(1);
            return true;
        } else if (i == R.id.navigation_cart) {
            mPager.setCurrentItem(2);
            return true;
        } else if (i == R.id.navigation_mine) {
            mPager.setCurrentItem(3);
            return true;
        }

        return false;
    }
}
