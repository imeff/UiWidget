package com.imef.uiwidget.activity.custom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;

import com.imef.uiwidget.activity.BaseActivity;
import com.imef.uiwidget.custom.OutlineTextView;

/**
 * Created by yqzheng on 2017/5/2.
 */

public class OutlineTextViewActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OutlineTextView outlineTextView = new OutlineTextView(this);
        outlineTextView.setText("测试");
        outlineTextView.setGravity(Gravity.CENTER);
        outlineTextView.setTextSize(50);
        setContentView(outlineTextView);
    }
}
