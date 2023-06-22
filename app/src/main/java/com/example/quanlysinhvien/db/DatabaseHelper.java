package com.example.quanlysinhvien.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="qlsv";
    private static final String TABLE_SINHVIEN="sinhvien";
    private static final String TABLE_LOP="lop";
    private static final String TABLE_DANGKY="dangky";
    private static final String sinhvien_ID = "id";
    private static final String ten = "ten";
    private static final String namsinh = "namsinh";
    private static final String quequan = "quequan";
    private static final String namhoc = "namhoc";
    private static final String lop_ID = "id";
    private static final String tenlop = "tenlop";
    private static final String mota = "mota";
    private static final String dangky_ID = "id";
    private static final String dangkySV_ID = "id_sinhvien";
    private static final String dangkyLop_ID = "id_lop";
    private Context context;

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
        this.context=context;
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String sqlQuery1="CREATE TABLE "+TABLE_SINHVIEN+" ("+
                sinhvien_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ten + " TEXT, "+
                namsinh + " INTEGER, "+
                quequan + " TEXT, "+
                namhoc + " TEXT)";
        db.execSQL(sqlQuery1);

        String sqlQuery2="CREATE TABLE "+TABLE_LOP+" ("+
                sinhvien_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                tenlop + " TEXT, "+
                mota + " TEXT)";
        db.execSQL(sqlQuery2);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_SINHVIEN);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_LOP);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_DANGKY);
        onCreate(db);
    }
}
