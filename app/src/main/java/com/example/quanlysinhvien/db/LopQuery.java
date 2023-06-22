package com.example.quanlysinhvien.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlysinhvien.models.Lop;

import java.util.ArrayList;
import java.util.List;

public class LopQuery {
    private static final String DATABASE_NAME = "qlsv";
    private DatabaseHelper databaseHelper;

    private static final String TABLE_NAME = "lop";

    private static final String lop_ID = "id";
    private static final String tenlop = "tenlop";
    private static final String mota = "mota";

    private Context context;
    public LopQuery(Context context) {
        this.context = context;
        this.databaseHelper = new DatabaseHelper(context);
    }
    public void add(Lop lop) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(tenlop, lop.getTenlop());
        values.put(mota, lop.getMota());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public List<Lop> getAll(){
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        String sqlQuery = "SELECT * FROM " + TABLE_NAME;
        List<Lop> listall = new ArrayList<>();
        Cursor cursor = db.rawQuery(sqlQuery, null);
        if(cursor.moveToFirst()) {
            do {
                Lop lop = new Lop();
                lop.setId(cursor.getInt(0));
                lop.setTenlop(cursor.getString(1));
                lop.setMota(cursor.getString(2));
                listall.add(lop);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return listall;
    }
}
