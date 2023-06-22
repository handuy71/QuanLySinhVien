package com.example.quanlysinhvien;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.quanlysinhvien.models.Lop;

import java.util.List;

public class LopAdapter extends ArrayAdapter<Lop> {
    public LopAdapter(Context context, List<Lop> list){
        super(context,R.layout.list_view_lop,list);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Lop lop = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_view_lop,parent,false);
        }

        TextView tenlop = convertView.findViewById(R.id.tenlop);
        TextView mota = convertView.findViewById(R.id.mota);


        tenlop.setText(lop.getTenlop());
        mota.setText(lop.getMota());

        return convertView;
    }
}
