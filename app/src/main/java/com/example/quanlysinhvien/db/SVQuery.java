package com.example.quanlysinhvien.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlysinhvien.models.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SVQuery {
    private static final String DATABASE_NAME = "qlsv";
    private DatabaseHelper databaseHelper;

    private static final String TABLE_NAME = "sinhvien";

    private static final String sinhvien_ID = "id";
    private static final String ten = "ten";
    private static final String namsinh = "namsinh";
    private static final String quequan = "quequan";
    private static final String namhoc = "namhoc";

    private Context context;
    public SVQuery(Context context) {
        this.context = context;
        this.databaseHelper = new DatabaseHelper(context);
    }
    public void add(SinhVien sv) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ten, sv.getTen());
        values.put(namsinh, sv.getNamsinh());
        values.put(quequan, sv.getQuequan());
        values.put(namhoc, sv.getNamhoc());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public List<SinhVien> getAll(){
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        String sqlQuery = "SELECT * FROM " + TABLE_NAME;
        List<SinhVien> listall = new ArrayList<>();
        Cursor cursor = db.rawQuery(sqlQuery, null);
        if(cursor.moveToFirst()) {
            do {
                SinhVien sv = new SinhVien();
                sv.setId(cursor.getInt(0));
                sv.setTen(cursor.getString(1));
                sv.setNamsinh(cursor.getInt(2));
                sv.setQuequan(cursor.getString(3));
                sv.setNamhoc(cursor.getString(4));
                listall.add(sv);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return listall;
    }

    public List<SinhVien> search(String ten, String namhoc) {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE " + SVQuery.ten + " LIKE '%" + ten + "%' AND " + SVQuery.namhoc + " LIKE '%" + namhoc + "%'";
        List<SinhVien> searchResults = new ArrayList<>();
        Cursor cursor = db.rawQuery(sqlQuery, null);
        if(cursor.moveToFirst()) {
            do {
                SinhVien sv = new SinhVien();
                sv.setId(cursor.getInt(0));
                sv.setTen(cursor.getString(1));
                sv.setNamsinh(cursor.getInt(2));
                sv.setQuequan(cursor.getString(3));
                sv.setNamhoc(cursor.getString(4));
                searchResults.add(sv);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return searchResults;
    }
    public List<SinhVien> searchTen(String ten) {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE " + SVQuery.ten + " LIKE '%" + ten + "%'";
        List<SinhVien> searchResults = new ArrayList<>();
        Cursor cursor = db.rawQuery(sqlQuery, null);
        if(cursor.moveToFirst()) {
            do {
                SinhVien sv = new SinhVien();
                sv.setId(cursor.getInt(0));
                sv.setTen(cursor.getString(1));
                sv.setNamsinh(cursor.getInt(2));
                sv.setQuequan(cursor.getString(3));
                sv.setNamhoc(cursor.getString(4));
                searchResults.add(sv);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return searchResults;
    }
    public List<SinhVien> searchNamhoc(String namhoc) {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        String sqlQuery = "SELECT * FROM " + TABLE_NAME + " WHERE " + SVQuery.namhoc + " LIKE '%" + namhoc + "%'";
        List<SinhVien> searchResults = new ArrayList<>();
        Cursor cursor = db.rawQuery(sqlQuery, null);
        if(cursor.moveToFirst()) {
            do {
                SinhVien sv = new SinhVien();
                sv.setId(cursor.getInt(0));
                sv.setTen(cursor.getString(1));
                sv.setNamsinh(cursor.getInt(2));
                sv.setQuequan(cursor.getString(3));
                sv.setNamhoc(cursor.getString(4));
                searchResults.add(sv);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return searchResults;
    }
}
