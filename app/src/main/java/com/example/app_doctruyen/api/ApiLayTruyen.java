package com.example.app_doctruyen.api;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.app_doctruyen.MainActivity;
import com.example.app_doctruyen.interfaces.LayTruyenVe;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

public class ApiLayTruyen extends AsyncTask<Void,Void,Void> {
    String data = null;
    LayTruyenVe layTruyenVe;
    public ApiLayTruyen(LayTruyenVe layTruyenVe) {
        this.layTruyenVe = layTruyenVe;
        this.layTruyenVe.BatDau();

    }
    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.jsonserve.com/14_yWv")
                .build();
        data = null;
        try {
            Response response = client.newCall(request).execute();
            ResponseBody body = response.body();
            data=body.string();
        }catch (IOException e){
            Log.e("AsyncTaskError", "Lỗi xảy ra: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        if (data == null){
            this.layTruyenVe.BiLoi();
        }else {
            this.layTruyenVe.KetThuc(data);
        }


    }


}
