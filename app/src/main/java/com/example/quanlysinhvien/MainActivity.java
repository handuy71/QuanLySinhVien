package com.example.quanlysinhvien;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.quanlysinhvien.db.SVQuery;
import com.example.quanlysinhvien.models.SinhVien;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView addSV,dsLop;
    ListView listSV;
    Button btnSearch;
    RadioGroup radioGroup;

    TextInputEditText search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addSV=findViewById(R.id.addSv);
        listSV=findViewById(R.id.listSV);
        dsLop=findViewById(R.id.DSLop);
        btnSearch=findViewById(R.id.btnSearch);
        search=findViewById(R.id.search);
        radioGroup = findViewById(R.id.namhoc);

        addSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AddSV.class);
                startActivityForResult(intent, 1);
            }
        });

        dsLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DanhSachLop.class);
                startActivityForResult(intent, 1);
            }
        });
        loadListSV();
        final String[] namhoc = new String[1];
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // on below line we are getting radio button from our group.
                RadioButton radioButton = findViewById(checkedId);

                // on below line we are displaying a toast message.
                namhoc[0] =radioButton.getText().toString();
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = search.getText().toString();
                searchByTenNamhoc(ten, namhoc[0]);
            }
        });
    }

    private void searchByTenNamhoc(String ten, String s) {
        SVQuery svQuery = new SVQuery(getBaseContext());
        List<SinhVien> sv = svQuery.search(ten,s);
        SVAdapter svAdapter = new SVAdapter(MainActivity.this,sv);
        listSV.setAdapter(svAdapter);
    }

    ;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((resultCode == RESULT_OK) && (requestCode == 1)) {
            Intent refresh = new Intent(this, MainActivity.class);
            startActivity(refresh);
            this.finish();
        }
        if ((resultCode == RESULT_OK) && (requestCode == 2)) {
            Intent refresh = new Intent(this, MainActivity.class);
            startActivity(refresh);
            this.finish();
        }
    }
    private void loadListSV() {
        SVQuery svQuery = new SVQuery(getBaseContext());
        List<SinhVien> sv = svQuery.getAll();
        SVAdapter svAdapter = new SVAdapter(MainActivity.this,sv);
        listSV.setAdapter(svAdapter);
    }



}