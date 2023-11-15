package com.example.app_doctruyen.object;

import org.json.JSONException;
import org.json.JSONObject;

public class TruyenTranh {
    private String tenTruyen,tenChap,linkTranh;


    public TruyenTranh(){
    }
    public TruyenTranh(JSONObject o) throws JSONException{
        tenTruyen = o.getString("tenTruyen");
        tenChap = o.getString("tenChap");
        linkTranh = o.getString("linkAnh");
    }
    public TruyenTranh(String tenTruyen, String tenChap, String linkTranh) {
        this.tenTruyen = tenTruyen;
        this.tenChap = tenChap;
        this.linkTranh = linkTranh;
    }

    public String getTenTruyen() {
        return tenTruyen;
    }

    public String getTenChap() {
        return tenChap;
    }

    public String getLinkTranh() {
        return linkTranh;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }

    public void setTenChap(String tenChap) {
        this.tenChap = tenChap;
    }

    public void setLinkTranh(String linkTranh) {
        this.linkTranh = linkTranh;
    }
}
