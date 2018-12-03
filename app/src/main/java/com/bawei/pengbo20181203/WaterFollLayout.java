package com.bawei.pengbo20181203;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * @author lenovo
 * 流式布局
 */
public class WaterFollLayout extends LinearLayout {
    /**
     * 定义布局中最高的TextView、
     * 布局的起始位置、
     * TextView左右上下间隔、
     *
     */
        int mMaxHeight;
        int left=0,top=0;
        int mHSpace=20,mVSpace=20;

    public WaterFollLayout(Context context) {
        super(context);
    }

    public WaterFollLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 得到最高的TextView
     */

    private void FindMaxHeight(){
            //初始化为0
        mMaxHeight=0;
        //得到所有的textView
        int count = getChildCount();
        for (int i = 0; i <count ; i++) {
            //得到当前指定textview
            View view = getChildAt(i);
            if (view.getMeasuredHeight()>mMaxHeight){
                mMaxHeight=view.getMeasuredHeight();
            }
        }
    }

    /**
     * 测量
     *    布局推荐宽高、
     *    子布局宽高
     *    是否换行、
     *    新换的行的高
     *    布局实际宽高
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            //得到布局推荐宽高
        int sizewidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
            //得到子布局宽高
        measureChildren(widthMeasureSpec,heightMeasureSpec);
            //得到textview最大高
            FindMaxHeight();
            //得到所有textview
        int count = getChildCount();
            //初始化布局的起始位置
            int left=0,top=0;
            //遍历
        for (int i = 0; i <count ; i++) {
                //得到当前textview
            View view = getChildAt(i);
            //换行的条件
            if (left!=0) {
                if ((left + view.getMeasuredWidth()) > sizewidth) {
                    //换行的高
                    top += mMaxHeight + mVSpace;
                    left = 0;
                }
            }
            //此时布局的起始left
            left+=view.getMeasuredWidth()+mHSpace;
        }
        //此时布局实际宽高
        setMeasuredDimension(sizewidth,sizeHeight>(top+mMaxHeight)?(top+mMaxHeight):sizeHeight);
    }

    /**
     * textview在布局中的位置
     *     通过布局的起始位置、
     *     是否换行、行高
     *     textview的宽高
     * @param changed
     * @param l
     * @param t
     * @param r
     * @param b
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
            //布局的起始位置
            int left=0,top=0;
            //最大textview高
            FindMaxHeight();
            //所有的textview
        int count = getChildCount();
            //遍历
        for (int i = 0; i <count ; i++) {
                //得到当前的textview
            View view = getChildAt(i);
            if (left!=0){
                if ((left+view.getMeasuredWidth())>getWidth()){
                    //换行
                    top+=mMaxHeight+mVSpace;
                    left=0;
                }
            }
            //定义当前textview的位置
            view.layout(left,top,left+view.getMeasuredWidth(),top+view.getMeasuredHeight());
            //此时的布局起始宽
            left+=view.getMeasuredWidth()+mHSpace;
        }
    }
}
