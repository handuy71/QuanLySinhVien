package com.example.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quanlysinhvien.db.SVQuery;
import com.example.quanlysinhvien.models.SinhVien;

public class AddSV extends AppCompatActivity {
    private EditText ten,namsinh,quequan,namhoc;
    private Button addButton;
    private SVQuery svQuery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sv);

        ten = findViewById(R.id.edit_text_ten);
        namsinh = findViewById(R.id.edit_text_namsinh);
        quequan = findViewById(R.id.edit_text_quequan);
        namhoc = findViewById(R.id.edit_text_namhoc);
        addButton = findViewById(R.id.button_save);

        svQuery = new SVQuery(this);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy thông tin sách từ các trường nhập liệu
                String Ten = ten.getText().toString();
                String Namhoc = namhoc.getText().toString();
                String Quequan = quequan.getText().toString();
                int Namsinh = Integer.parseInt(namsinh.getText().toString());

                // Tạo đối tượng Book từ thông tin nhập liệu
                SinhVien sv = new SinhVien(Ten, Namsinh, Quequan, Namhoc);

                // Thêm sách mới vào cơ sở dữ liệu
                svQuery.add(sv);

                // Hiển thị thông báo thành công
                Toast.makeText(AddSV.this, "Thêm sinh viên thành công", Toast.LENGTH_SHORT).show();

                // Xóa dữ liệu trong các trường nhập liệu
                ten.setText("");
                namhoc.setText("");
                quequan.setText("");
                namsinh.setText("");
                setResult(RESULT_OK, null);

                finish();
            }
        });
    }
}