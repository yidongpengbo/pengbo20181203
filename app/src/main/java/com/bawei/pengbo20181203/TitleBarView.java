package com.bawei.pengbo20181203;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * @author lenovo
 * 创建放大镜和输入框
 */
public class TitleBarView extends LinearLayout {
            private Context context;
            private ImageView seach;
            private EditText edit;


    public TitleBarView(Context context) {
        super(context);
        this.context=context;
        init();
    }

    public TitleBarView(Context context,  @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        init();
    }

    private void init() {
        //获取view
        View view = View.inflate(context, R.layout.titlebarview, null);
        //获取资源ID
       seach= view.findViewById(R.id.seach);
       edit=view.findViewById(R.id.edit);
       //图片点击事件
        seach.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                    //调用接口，将输入的值放入到接口
                if (callBack!=null){
                    callBack.onsuccess(edit.getText().toString());
                }
            }
        });
    }

    /**
     * 定义接口，并定义方法，给参数
     */
    public interface CallBack{
        void onsuccess(String str);
    }

    /**
     * 初始化成员变量
     */
    CallBack callBack;

    /**
     * 传值
     */
    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }


}
