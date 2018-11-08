package yann.module.base;


import android.support.annotation.Keep;
import android.view.View;

@Keep
public interface IViewDelegate {

    BaseFragment getFragment(String name);

    View getView(String name);

}
