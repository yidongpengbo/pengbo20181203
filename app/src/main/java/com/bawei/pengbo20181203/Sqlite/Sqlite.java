package com.bawei.pengbo20181203.Sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

/**
 * @author lenovo
 *  创建数据库及表
 */
public class Sqlite extends SQLiteOpenHelper {
    public Sqlite( @Nullable Context context) {
        super(context, "Peng.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table  peng(id integer primary key autoincrement," +
                "str text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
