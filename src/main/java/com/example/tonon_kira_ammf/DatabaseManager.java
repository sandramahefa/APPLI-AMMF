package com.example.tonon_kira_ammf;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Hira.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseManager(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    public void insertHira(String lohateny,String sokajy, String anarana){
        String strSql = "insert into tononkira(lohateny,sokajy,anarana) values ('"+lohateny +"','" + sokajy + "','" + anarana + "')";
        this.getWritableDatabase().execSQL(strSql);
        Log.i("DATABASE", "Insert invoked");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String strSql = "CREATE TABLE tononkira (" +
                "id_hira integer primary key autoincrement ," +
                "lohateny text not null ," +
                "sokajy text not null ," +
                "anarana text not null" +
                ")";
        sqLiteDatabase.execSQL(strSql);
//        this.insertHira("Ilay mpiandry ahy","karemy","ilay_mpiandry_ahy");
//        this.insertHira("Jesoa teny tonga nofo","krismasy","jesoa_teny_tonga_nofo");
//        this.insertHira("Mankalaza","paka","mankalaza");
//        this.insertHira("Manompo anao","avant","manompo_anao");
//        this.insertHira("Masina Maria","patekoty","masina_maria");
        Log.i("DATABASE", "onCreate invoked");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String strString = "drop table tononkira";
        sqLiteDatabase.execSQL(strString);
        Log.i("DATABASE", "onUpgrade invoked");

    }


    public Cursor getALl(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM tononkira",null);
        return res;
    }

    public Cursor getSokajy( String sokajy){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM tononkira WHERE sokajy ='"+sokajy+ "'",null);
        return res;
    }
    public Cursor getLOhateny( String lohateny){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM tononkira WHERE lohateny LIKE '%"+lohateny+ "%'",null);
        return res;
    }

    public Cursor getLohatenySokajy( String lohateny,String sokajy){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM tononkira WHERE lohateny LIKe '%"+lohateny+"%' AND +sokajy ='"+sokajy+ "'",null);
        return res;
    }

    public void deleteAll(){
        String SQL = "delete from tononkira";
        this.getWritableDatabase().execSQL(SQL);
    }
}
