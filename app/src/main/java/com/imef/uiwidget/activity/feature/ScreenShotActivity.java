package com.imef.uiwidget.activity.feature;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.imef.uiwidget.R;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by yqzheng on 2017/5/3.
 */


public class ScreenShotActivity extends Activity {


    private Button
            button;


    /**
     * Called when the activity is first created.
     */

    @Override

    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_screen_shot);

        this.button = (Button) this.findViewById(R.id.my_button);

        this.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.US);
                String fname = "/sdcard/" + sdf.format(new Date()) + ".png";
                View view = v.getRootView();
                view.setDrawingCacheEnabled(true);
                view.buildDrawingCache();
                Bitmap bitmap = view.getDrawingCache();
                if (bitmap != null) {
                    System.out.println("bitmap got!");
                    try {
                        FileOutputStream out = new FileOutputStream(fname);
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
                        System.out.println("file" + fname + "output done.");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("bitmap is NULL !");
                }
            }
        });
    }
}