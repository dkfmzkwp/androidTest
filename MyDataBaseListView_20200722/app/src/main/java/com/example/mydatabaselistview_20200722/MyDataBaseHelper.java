package com.example.mydatabaselistview_20200722;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class MyDataBaseHelper extends SQLiteOpenHelper {
    private Context context;
    private SQLiteDatabase sqLiteDatabase;

    public MyDataBaseHelper(Context context, String dbName){
        super(context, dbName, null, 1);
        this.context = context;
    }

    //테이블 생성
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table groupTBL(name char(20) primary key, count integer);");
    }

    //테이블 삭제
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists groupTBL;");
        onCreate(sqLiteDatabase);
    }

    public boolean insertTBL(PersonModel personModel){
        boolean returnValue = false;

        try {
        sqLiteDatabase = this.getWritableDatabase();
        String name =personModel.getName();
        int count = personModel.getCount();

        String qString ="insert into groupTBL values('"+name+"',"+count+");";
        sqLiteDatabase.execSQL(qString);
        returnValue = true;
        }
        catch (SQLException e){
            Log.d("database", e.getMessage());
            returnValue = false;
        }finally{
            sqLiteDatabase.close();
        }

        return returnValue;
    }

    public boolean updateTBL(PersonModel personModel){
        boolean returnValue = false;

        try {
            sqLiteDatabase = this.getWritableDatabase();
            String name =personModel.getName();
            int count = personModel.getCount();
            String qString ="update groupTBL set count='"+count+"' where name='"+name+"';";
            sqLiteDatabase.execSQL(qString);
            returnValue = true;
        }
        catch (SQLException e){
            Log.d("database", e.getMessage());
            returnValue = false;
        }finally{
            sqLiteDatabase.close();
        }

        return returnValue;
    }

    public boolean deleteTBL(PersonModel personModel){
        boolean returnValue = false;

        try {
            sqLiteDatabase = this.getWritableDatabase();
            String name =personModel.getName();
            String qString ="delete from groupTBL where name='"+name+"';";
            sqLiteDatabase.execSQL(qString);
            returnValue = true;
        }
        catch (SQLException e){
            Log.d("database", e.getMessage());
            returnValue = false;
        }finally{
            sqLiteDatabase.close();
        }

        return returnValue;
    }

    public ArrayList<PersonModel> selectTBL(){
        ArrayList<PersonModel> array= new ArrayList<PersonModel>();

        sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from groupTBL;",null);

        while(cursor.moveToNext()){
            PersonModel personModel = new PersonModel(cursor.getString(0),cursor.getInt(1));
            array.add(personModel);
        }

        cursor.close();
        sqLiteDatabase.close();

        return array;
    }


}
