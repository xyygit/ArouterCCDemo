package yann.module.utils;

/**
 * Created by yayun.xia on 2018/11/9
 */
public class RouteUtils {

    public final static String NEED_LOGIN = "/need_login";

    //首页
    public final static String HOME_ACTIVITY = "/home/activity";
    public final static String HOME_FRAGMENT_MAIN = "/home/frgament/main";

    //分类页
    public final static String CATEGORY_FRAGMENT_MAIN = "/category/frgament/main";

    //购物车
    public final static String CART_FRAGMENT_MAIN = "/cart/frgament/main";
    public final static String CART_ACTIVITY = "/cart/activity";

    //用户中心
    public final static String CENTER_FRAGMENT_MAIN = "/center/frgament/main";
    public final static String CENTER_SETTING = "/center/setting";

    //登录
    public final static String LOGIN = "/login/login";

    //订单
    public final static String ORDER_LIST = NEED_LOGIN + "/order/list";
    public final static String ORDER_DETAIL = NEED_LOGIN + "/order/detail";

    //普通跳转测试
    public final static String TEST_COMMON = "/test/commom";
    public final static String FORRESULT_TEST = "/test/forresult";
    public final static String TEST_PARAM = "/test/param";

    //拦截器测试
    public final static String TEST_LOGIN = NEED_LOGIN + "/test/login";


}
