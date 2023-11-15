package com.example.app_doctruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.example.app_doctruyen.adapter.TruyenTranhAdapter;
import com.example.app_doctruyen.api.ApiLayTruyen;
import com.example.app_doctruyen.interfaces.LayTruyenVe;
import com.example.app_doctruyen.object.TruyenTranh;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LayTruyenVe {
GridView gdvDSTruyen;
TruyenTranhAdapter adapter;
EditText edtTimKiem;
ArrayList<TruyenTranh> truyenTranhArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        anhXa();
        setUp();
        setClick();
        new ApiLayTruyen(this).execute();
    }
    private void init(){
        truyenTranhArrayList = new ArrayList<>();
//        truyenTranhArrayList.add(new TruyenTranh("Haikyuu","Chuong 374","https://nettruyenco.vn/public/images/comics/haikyuu.jpg"));
//        truyenTranhArrayList.add(new TruyenTranh("Quái Vật Nhạc Viên","Chapter 62","https://nettruyenco.vn/public/images/comics/quai-vat-nhac-vien.jpg"));
//        truyenTranhArrayList.add(new TruyenTranh("Quỷ Ấn","Chapter 27","https://nettruyenco.vn/public/images/comics/quy-an.jpg"));
//        truyenTranhArrayList.add(new TruyenTranh("Bách luyện thành thần","Chapter 1111","https://nettruyenco.vn/public/images/comics/bach-luyen-thanh-than.jpg"));
//        truyenTranhArrayList.add(new TruyenTranh("Haikyuu","Chuong 374","https://nettruyenco.vn/public/images/comics/haikyuu.jpg"));
//        truyenTranhArrayList.add(new TruyenTranh("Quái Vật Nhạc Viên","Chapter 62","https://nettruyenco.vn/public/images/comics/quai-vat-nhac-vien.jpg"));
//        truyenTranhArrayList.add(new TruyenTranh("Quỷ Ấn","Chapter 27","https://nettruyenco.vn/public/images/comics/quy-an.jpg"));
//        truyenTranhArrayList.add(new TruyenTranh("Bách luyện thành thần","Chapter 1111","https://nettruyenco.vn/public/images/comics/bach-luyen-thanh-than.jpg"));
//        truyenTranhArrayList.add(new TruyenTranh("Haikyuu","Chuong 374","https://nettruyenco.vn/public/images/comics/haikyuu.jpg"));
//        truyenTranhArrayList.add(new TruyenTranh("Quái Vật Nhạc Viên","Chapter 62","https://nettruyenco.vn/public/images/comics/quai-vat-nhac-vien.jpg"));
//        truyenTranhArrayList.add(new TruyenTranh("Quỷ Ấn","Chapter 27","https://nettruyenco.vn/public/images/comics/quy-an.jpg"));
//        truyenTranhArrayList.add(new TruyenTranh("Bách luyện thành thần","Chapter 1111","https://nettruyenco.vn/public/images/comics/bach-luyen-thanh-than.jpg"));
        adapter = new TruyenTranhAdapter(this, 0, truyenTranhArrayList);
    }
    private void anhXa(){
        gdvDSTruyen = findViewById(R.id.gdvDSTruyen);
        edtTimKiem = findViewById(R.id.edtTimKiem);

    }
    private void setUp(){
        gdvDSTruyen.setAdapter(adapter);
    }
    private void setClick(){
        edtTimKiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String s = edtTimKiem.getText().toString();
                adapter.sortTruyen(s);

            }
        });
    }

    @Override
    public void BatDau() {
        Toast.makeText(this,"Dang tai", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void KetThuc(String data) {
        try {
            JSONArray arr = new JSONArray(data);
            for (int i = 0; i < arr.length(); i++) {
                JSONObject o = arr.getJSONObject(i);
                truyenTranhArrayList.add(new TruyenTranh(o));
            }
            adapter = new TruyenTranhAdapter(this, 0, truyenTranhArrayList);
            gdvDSTruyen.setAdapter(adapter);
            Toast.makeText(this, "Thành công", Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace(); // In thông tin lỗi để biết lý do xảy ra vấn đề
            Toast.makeText(this, "Lỗi xảy ra khi xử lý dữ liệu JSON", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void BiLoi() {
        Toast.makeText(this,"Bi Loi", Toast.LENGTH_SHORT).show();


    }
    public void showToastFromApi(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}