package com.example.app_doctruyen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.app_doctruyen.R;
import com.example.app_doctruyen.object.TruyenTranh;

import java.util.ArrayList;
import java.util.List;

public class TruyenTranhAdapter extends ArrayAdapter<TruyenTranh> {
    private Context ct;
    private ArrayList<TruyenTranh> arr;

    public TruyenTranhAdapter(Context context, int resource, List<TruyenTranh> objects) {
        super(context, resource, objects);
        this.ct = context;
        this.arr = new ArrayList<>(objects);
    }
    // sap xep truyen
    public void sortTruyen(String s){
        s= s.toUpperCase();
        int k=0;
        for(int i=0; i< arr.size();i++){
            TruyenTranh t = arr.get(i);
            String ten  = t.getTenTruyen().toUpperCase();
            if(ten.indexOf(s)>= 0){
                arr.set(i,arr.get(k));
                arr.set(k,t);
                k++;
            }

        }
        notifyDataSetChanged(); // ham load lai list truyen sau khi sap xep
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_truyen, null);
        }
        if ((arr.size() > 0)) {
            TruyenTranh truyenTranh = this.arr.get(position);
            TextView tenTruyen = convertView.findViewById(R.id.txvTenTruyen);
            TextView tenChap = convertView.findViewById(R.id.txvTenChap);
            ImageView imgAnhTruyen = convertView.findViewById(R.id.imgAnhTruyen);

            tenTruyen.setText(truyenTranh.getTenTruyen());
            tenChap.setText(truyenTranh.getTenChap());
            Glide.with(this.ct).load(truyenTranh.getLinkTranh()).into(imgAnhTruyen);

        }
        return convertView;
    }

}
