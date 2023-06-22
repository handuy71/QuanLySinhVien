package com.example.quanlysinhvien;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.quanlysinhvien.models.SinhVien;

import java.util.List;

public class SVAdapter extends ArrayAdapter<SinhVien> {
    public SVAdapter(Context context, List<SinhVien> list){
        super(context,R.layout.list_view_sv,list);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        SinhVien sv = getItem(position);

        if(convertView==null){
            convertView=LayoutInflater.from(getContext()).inflate(R.layout.list_view_sv,parent,false);
        }
        TextView ten = convertView.findViewById(R.id.ten);
        TextView namsinh = convertView.findViewById(R.id.namsinh);
        TextView quequan = convertView.findViewById(R.id.quequan);
        TextView namhoc = convertView.findViewById(R.id.namhoc);

        ten.setText(sv.getTen());
        namsinh.setText("" + sv.getNamsinh());
        quequan.setText(sv.getQuequan());
        namhoc.setText(sv.getNamhoc());

        return convertView;
    }
}
