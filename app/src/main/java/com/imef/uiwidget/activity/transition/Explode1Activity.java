package com.imef.uiwidget.activity.transition;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;

import com.imef.uiwidget.activity.BaseActivity;

/**
 * Created by yqzheng on 2017/4/27.
 */

public class Explode1Activity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
    }
}
