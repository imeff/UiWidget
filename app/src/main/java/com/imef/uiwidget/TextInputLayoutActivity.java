package com.imef.uiwidget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;

/**
 * Created by Administrator on 2017/4/11.
 */

public class TextInputLayoutActivity extends BaseActivity {

    private TextInputLayout mlayout1, mlayout2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textinputlayouy);
        mlayout1 = (TextInputLayout) findViewById(R.id.text_input_layout1);
        mlayout1.setHint("测试1");

        mlayout2 = (TextInputLayout) findViewById(R.id.text_input_layout2);
        mlayout2.setHint("测试2");
    }
}
