package com.example.quanlysinhvien;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.quanlysinhvien.db.LopQuery;
import com.example.quanlysinhvien.models.Lop;

import java.util.List;

public class DanhSachLop extends AppCompatActivity {
    TextView addLop,dsSV;
    ListView listLop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_lop);
        addLop=findViewById(R.id.addLop);
        listLop=findViewById(R.id.listLop);
        dsSV=findViewById(R.id.DSSV);

        addLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AddLop.class);
                startActivityForResult(intent, 1);
            }
        });

        dsSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(intent, 1);
            }
        });
        loadListLop();
    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((resultCode == RESULT_OK) && (requestCode == 1)) {
            Intent refresh = new Intent(this, DanhSachLop.class);
            startActivity(refresh);
            this.finish();
        }
        if ((resultCode == RESULT_OK) && (requestCode == 2)) {
            Intent refresh = new Intent(this, DanhSachLop.class);
            startActivity(refresh);
            this.finish();
        }
    }
    private void loadListLop() {
        LopQuery lopQuery = new LopQuery(getBaseContext());
        List<Lop> lop = lopQuery.getAll();
        LopAdapter lopAdapter = new LopAdapter(DanhSachLop.this,lop);
        listLop.setAdapter(lopAdapter);
    }
}