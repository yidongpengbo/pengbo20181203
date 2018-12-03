package com.bawei.pengbo20181203.Sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DaoSqlite {
    private Context context;
    private SQLiteDatabase database;
    private static  DaoSqlite instance;
    private DaoSqlite(Context context){
        this.context=context;
        Sqlite sqlite = new Sqlite(context);
         database = sqlite.getWritableDatabase();
    }
    public static DaoSqlite getInstance(Context context){
        if (instance!=null){
            instance=new DaoSqlite(context);
        }
        return instance;
    }

    //添加
    public void add(String str){
        ContentValues values=new ContentValues();
        values.put("str",str);
        database.insert("peng",null,values);
    }

    //清除
    public void del(){
        database.delete("peng",null,null);
    }
}
