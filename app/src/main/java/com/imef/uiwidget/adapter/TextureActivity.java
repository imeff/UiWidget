package com.imef.uiwidget.adapter;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.TextureView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.imef.uiwidget.BaseActivity;
import com.imef.uiwidget.R;

import java.io.IOException;

/**
 * Created by Administrator on 2017/4/12.
 */

public class TextureActivity extends BaseActivity implements TextureView.SurfaceTextureListener {

    private TextureView mTextureView;
    private Camera mCamera;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texture_camera);
        mTextureView = (TextureView) findViewById(R.id.textureView);
        mTextureView.setSurfaceTextureListener(this);
    }


    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        mCamera = Camera.open();
        Camera.Size previewSize = mCamera.getParameters().getPreviewSize();

        mTextureView.setRotation(90.0f);
        mTextureView.setLayoutParams(new RelativeLayout.LayoutParams(
                previewSize.width, previewSize.height));
        try {
            mCamera.setPreviewTexture(surface);
        } catch (IOException t) {
        }
        mCamera.startPreview();
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        mCamera.stopPreview();
        mCamera.release();
        return true;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

    }
}
