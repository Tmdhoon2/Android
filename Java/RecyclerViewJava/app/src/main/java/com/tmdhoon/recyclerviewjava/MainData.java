package com.tmdhoon.recyclerviewjava;

import android.text.Editable;
import android.widget.EditText;

public class MainData{

    private int iv_profile;
    private Editable tv_name;

    public MainData(int iv_profile, Editable tv_name) {
        this.iv_profile = iv_profile;
        this.tv_name = tv_name;
    }

    public int getIv_profile() {
        return iv_profile;
    }

    public void setIv_profile(int iv_profile) {
        this.iv_profile = iv_profile;
    }

    public Editable getTv_name() {
        return tv_name;
    }

    public void setTv_name(Editable tv_name) {
        this.tv_name = tv_name;
    }
}