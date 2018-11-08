package yann.module_main.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import yann.module.base.BaseActivity;
import yann.module_main.R;
import yann.module_main.fragment.CartFragment;
import yann.module_main.fragment.CategoryFragment;
import yann.module_main.fragment.CenterFragment;
import yann.module_main.fragment.HomeFragment;
import yann.module_main.model.Tab;

public class MainActivity extends BaseActivity {

    /**
     * 定义FragmentTabHost对象
     */
    private FragmentTabHost mTabHost;

    /**
     * 定义一个布局填充器对象
     */
    private LayoutInflater mInflater;

    /**
     * 定义一个ArrayList来存放Tab
     */
    private List<Tab> mTabs = new ArrayList<>(4);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTab();
    }

    /**
     * 初始化Tab
     */
    private void initTab() {
        Tab tab_home = new Tab(HomeFragment.class, R.string.home, R.drawable.selector_icon_home);
        Tab tab_category = new Tab(CategoryFragment.class, R.string.catagory, R.drawable.selector_icon_category);
        Tab tab_cart = new Tab(CartFragment.class, R.string.cart, R.drawable.selector_icon_cart);
        Tab tab_mine = new Tab(CenterFragment.class, R.string.mine, R.drawable.selector_icon_user_center);

        mTabs.add(tab_home);
        mTabs.add(tab_category);
        mTabs.add(tab_cart);
        mTabs.add(tab_mine);

        mInflater = LayoutInflater.from(this);
        mTabHost = (FragmentTabHost) this.findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        for (Tab tab : mTabs) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(getString(tab.getTitle()));
            tabSpec.setIndicator(buildIndicator(tab));
            mTabHost.addTab(tabSpec, tab.getFragment(), null);
        }
    }

    /**
     * 给Tab设置图标跟文字
     *
     * @param tab
     * @return
     */
    private View buildIndicator(Tab tab) {

        View view = mInflater.inflate(R.layout.layout_tab_item, null);
        ImageView img = (ImageView) view.findViewById(R.id.iv_tab_item);
        TextView text = (TextView) view.findViewById(R.id.tv_tab_item);

        img.setBackgroundResource(tab.getIcon());
        text.setText(tab.getTitle());

        return view;
    }
}
