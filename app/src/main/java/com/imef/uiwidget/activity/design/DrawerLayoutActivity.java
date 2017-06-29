package com.imef.uiwidget.activity.design;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;

import com.imef.uiwidget.R;
import com.imef.uiwidget.activity.BaseActivity;

/**
 * Created by Administrator on 2017/4/11.
 */

public class DrawerLayoutActivity extends BaseActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.openDrawer(Gravity.RIGHT);
        mDrawerLayout.setScrimColor((Color.TRANSPARENT));
    }
}
