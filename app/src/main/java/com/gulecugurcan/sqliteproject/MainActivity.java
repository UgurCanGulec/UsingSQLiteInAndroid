package com.gulecugurcan.sqliteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //SQLite tanımı için gereken kodlar
        try{
            //Veri tabanı oluşturma işlemi
            SQLiteDatabase database= this.openOrCreateDatabase("Musicians",MODE_PRIVATE,null);
            //Tablo oluşturma işlemi ve veri ekleme
            database.execSQL("CREATE TABLE IF NOT EXISTS musicians (id INTEGER PRIMARY KEY, name VARCHAR,age INT)");
            database.execSQL("INSERT INTO musicians (name,age) VALUES ('James',50)");
            database.execSQL("UPDATE musicians SET age=61 WHERE name='James'");
            database.execSQL("DELETE FROM musicians WHERE id=1");
            //Veri çekme veritabanından
            Cursor cursor=database.rawQuery("SELECT * FROM musicians WHERE name LIKE '%s'",null);

            int nameIndex=cursor.getColumnIndex("name");
            int ageIndex=cursor.getColumnIndex("age");
            int idIndex=cursor.getColumnIndex("id");
            while(cursor.moveToNext()){
               // String isim=cursor.getString(nameIndex);
                //int yas=cursor.getInt(ageIndex);
                //int id=cursor.getInt(idIndex);
            }
            cursor.close();

        }catch (Exception e) {
            e.printStackTrace();

        }

    }
}