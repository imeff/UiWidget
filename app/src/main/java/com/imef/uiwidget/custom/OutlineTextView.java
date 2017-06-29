package com.imef.uiwidget.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

import com.imef.uiwidget.R;

import java.lang.reflect.Field;

/**
 * Created by yqzheng on 2017/5/2.
 */

public class OutlineTextView extends android.support.v7.widget.AppCompatTextView {
    public OutlineTextView(Context context) {
        super(context);
        //获取对应的属性值
        m_TextPaint = this.getPaint();
        this.mInnerColor = getResources().getColor(android.R.color.darker_gray);
        this.mOuterColor = getResources().getColor(android.R.color.holo_red_light);;
    }

    TextPaint m_TextPaint;
    int mInnerColor;
    int mOuterColor;

    private boolean m_bDrawSideLine = true;

    @Override
    protected void onDraw(Canvas canvas) {
        if (m_bDrawSideLine) {
            // 描外层
//             super.setTextColor(Color.BLUE); // 不能直接这么设，如此会导致递归
            setTextColorUseReflection(mOuterColor);
            m_TextPaint.setStrokeWidth(5); // 描边宽度
            m_TextPaint.setStyle(Paint.Style.FILL_AND_STROKE); // 描边种类
            m_TextPaint.setFakeBoldText(true); // 外层text采用粗体
            m_TextPaint.setShadowLayer(1, 0, 0, 0); // 字体的阴影效果，可以忽略
            super.onDraw(canvas);

            // 描内层，恢复原先的画笔

            // super.setTextColor(Color.BLUE); // 不能直接这么设，如此会导致递归
            setTextColorUseReflection(mInnerColor);
            m_TextPaint.setStrokeWidth(0);
            m_TextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            m_TextPaint.setFakeBoldText(false);
            m_TextPaint.setShadowLayer(0, 0, 0, 0);

        }
        super.onDraw(canvas);
    }

    private void setTextColorUseReflection(int color) {
        Field textColorField;
        try {
            textColorField = TextView.class.getDeclaredField("mCurTextColor");
            textColorField.setAccessible(true);
            textColorField.set(this, color);
            textColorField.setAccessible(false);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        m_TextPaint.setColor(color);
    }
}
