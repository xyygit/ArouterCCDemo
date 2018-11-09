package yann.module.utils;

import com.alibaba.android.arouter.launcher.ARouter;

import yann.module.base.BaseFragment;

/**
 * Created by yayun.xia on 2018/11/9
 */
public class FragmentUtils {
    private FragmentUtils() {
    }

    public static FragmentUtils getInstance() {
        return FragmentUtilsHolder.sInstance;
    }

    private static class FragmentUtilsHolder {
        private static final FragmentUtils sInstance = new FragmentUtils();
    }

    /**
     * 获取首页fragment
     *
     * @return
     */
    public BaseFragment getHomeFragment() {
        BaseFragment fragment = (BaseFragment) ARouter.getInstance().build(RouteUtils.HOME_FRAGMENT_MAIN).navigation();
        return fragment;
    }

    /**
     * 获取分类页fragment
     *
     * @return
     */
    public BaseFragment getCategoryFragment() {
        BaseFragment fragment = (BaseFragment) ARouter.getInstance().build(RouteUtils.CATEGORY_FRAGMENT_MAIN).navigation();
        return fragment;
    }

    /**
     * 获取购物车fragment
     *
     * @return
     */
    public BaseFragment getCartFragment() {
        BaseFragment fragment = (BaseFragment) ARouter.getInstance().build(RouteUtils.CART_FRAGMENT_MAIN).navigation();
        return fragment;
    }

    /**
     * 获取个人中心fragment
     *
     * @return
     */
    public BaseFragment getCenterFragment() {
        BaseFragment fragment = (BaseFragment) ARouter.getInstance().build(RouteUtils.CENTER_FRAGMENT_MAIN,"center").navigation();
        return fragment;
    }
}
