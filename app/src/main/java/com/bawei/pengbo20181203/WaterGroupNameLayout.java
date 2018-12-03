package com.bawei.pengbo20181203;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * @author lenovo
 * 定义最近搜索和搜索发现
 */
public class WaterGroupNameLayout extends LinearLayout {
    public WaterGroupNameLayout(Context context) {
        super(context);
    }

    public WaterGroupNameLayout(Context context,  @Nullable AttributeSet attrs) {
        super(context, attrs);
        //自定义属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.WaterGroupNameLayout);
        int color = typedArray.getColor(R.styleable.WaterGroupNameLayout_textColor, Color.YELLOW);
        //?????
       // setTextColor(color);
        typedArray.recycle();
    }

}
