package com.yann.module.login.interceptor;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;
import yann.module.utils.RouteUtils;
import yann.module.utils.ToastUtils;
import yann.module.utils.Utils;

/**
 * Created by yayun.xia on 2018/11/9
 * <p>
 * 添加拦截器的时候，建议clean再打包运行，不然会出现，无效的情况
 * <p>
 * 切记一个项目里面priority的值保证唯一，不然会出毛病
 */
@Interceptor(priority = 2, name = "登录拦截")
public class LoginInterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        if (postcard.getGroup().equals("need_login")) {
            ToastUtils.showLongToast("需要去登陆");
            callback.onInterrupt(null);
            ARouter.getInstance()
                    .build(RouteUtils.LOGIN)
                    .withString("path", postcard.getPath())
                    .navigation(Utils.getContext(), new NavCallback() {
                                @Override
                                public void onFound(Postcard postcard) {
                                    super.onFound(postcard);
                                    //路由目标被发现时调用
                                    Log.e("LoginInterceptor", "发现登录路由");
                                }

                                @Override
                                public void onLost(Postcard postcard) {
                                    super.onLost(postcard);
                                    //路由被丢失时调用
                                    Log.e("LoginInterceptor", "登录路由丢失。。。");
                                }

                                @Override
                                public void onArrival(Postcard postcard) {
                                    //路由到达之后调用
                                    Log.e("LoginInterceptor", "到达登录页^_^");
                                }

                                @Override
                                public void onInterrupt(Postcard postcard) {
                                    super.onInterrupt(postcard);
                                    //路由被拦截时调用
                                    Log.e("LoginInterceptor", "跳转登录被拦截了。。。");
                                }
                            });
        } else {
            postcard.withString("extra", "我是在拦截器中附加的参数");
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {

    }
}
