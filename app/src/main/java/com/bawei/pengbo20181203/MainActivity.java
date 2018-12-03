package com.bawei.pengbo20181203;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.pengbo20181203.Sqlite.DaoSqlite;

/**
 * @author lenovo
 *
 */
public class MainActivity extends AppCompatActivity {
            TitleBarView titleBarView;
            WaterFollLayout foll_seach,foll_hot;
            ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取资源ID
        titleBarView=findViewById(R.id.titleBarView);
        foll_seach=findViewById(R.id.foll_seach);
        foll_hot=findViewById(R.id.foll_hot);
        imageView=findViewById(R.id.image);

        //titleBarView的接口回调
            titleBarView.setCallBack(new TitleBarView.CallBack() {
                @Override
                public void onsuccess(String str) {
                    TextView view = new TextView(MainActivity.this);
                    //添加输入的值
                    view.setText(str);
                    //添加到流式布局
                    foll_seach.addView(view);
                    //导入数据库
                    DaoSqlite.getInstance(MainActivity.this).add(str);
                }
            });
            //清空
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    DaoSqlite.getInstance(MainActivity.this).del();
            }
        });

       //吐司
       titleBarView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(MainActivity.this,"数据"+v,Toast.LENGTH_LONG).show();
           }
       });

       //搜索发现
        for (int i = 0; i <30 ; i++) {
            TextView view = new TextView(MainActivity.this);
            view.setText("数据"+i);
            foll_hot.addView(view);
            DaoSqlite.getInstance(this).add("数据"+i);
        }

    }
}
