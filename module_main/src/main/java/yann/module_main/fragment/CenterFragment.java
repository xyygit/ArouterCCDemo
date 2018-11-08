package yann.module_main.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yann.module.base.BaseFragment;
import yann.module_main.R;

public class CenterFragment extends BaseFragment {
    private final static String TAG = CenterFragment.class.getSimpleName();

    public static CenterFragment newInstance(String content) {
        Bundle arg = getBundle(content);

        CenterFragment fragment = new CenterFragment();
        fragment.setArguments(arg);
        return fragment;
    }

    @NonNull
    public static Bundle getBundle(String content) {
        Bundle arg = new Bundle();
        arg.putString("content", content);
        return arg;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle arg = getArguments();
        if(arg != null){
            String content = arg.getString("content");
            Log.d(TAG, content);
        }

        return inflater.inflate(R.layout.fragment_main_user_center, container, false);
    }
}
