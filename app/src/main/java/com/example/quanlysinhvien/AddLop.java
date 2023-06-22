package com.example.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quanlysinhvien.db.LopQuery;
import com.example.quanlysinhvien.models.Lop;

public class AddLop extends AppCompatActivity {
    private EditText tenlop,mota;
    private Button addButton;
    private LopQuery lopQuery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lop);

        tenlop = findViewById(R.id.edit_text_tenlop);
        mota = findViewById(R.id.edit_text_mota);
        addButton = findViewById(R.id.button_save);

        lopQuery = new LopQuery(this);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy thông tin sách từ các trường nhập liệu
                String Tenlop = tenlop.getText().toString();
                String Mota = mota.getText().toString();

                // Tạo đối tượng Book từ thông tin nhập liệu
                Lop lop = new Lop(Tenlop, Mota);

                // Thêm sách mới vào cơ sở dữ liệu
                lopQuery.add(lop);

                // Hiển thị thông báo thành công
                Toast.makeText(AddLop.this, "Thêm lớp thành công", Toast.LENGTH_SHORT).show();

                // Xóa dữ liệu trong các trường nhập liệu
                tenlop.setText("");
                mota.setText("");
                setResult(RESULT_OK, null);
                finish();
            }
        });
    }
}