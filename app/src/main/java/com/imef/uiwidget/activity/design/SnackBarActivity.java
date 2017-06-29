package com.imef.uiwidget.activity.design;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;

import com.imef.uiwidget.R;
import com.imef.uiwidget.activity.BaseActivity;

/**
 * Created by imef on 2017/4/11.
 */

public class SnackBarActivity extends BaseActivity {

    private View view;
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);
        view = findViewById(R.id.view);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setVisibility(View.GONE);

                Snackbar.make(button , "测试", Snackbar.LENGTH_LONG).setAction("撤销", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        button.setVisibility(View.VISIBLE);
                    }
                }).show();
            }
        });


    }
}
