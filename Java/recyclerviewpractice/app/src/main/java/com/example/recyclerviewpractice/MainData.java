package com.example.recyclerviewpractice;

import android.text.Editable;

public class MainData {

    private int iv_profile;
    private String tv_name;
    private String tv_birth;

    public MainData(int iv_profile, String  tv_name, String tv_birth) {
        this.iv_profile = iv_profile;
        this.tv_name = tv_name;
        this.tv_birth = tv_birth;
    }

    public int getIv_profile() {                                                                    // iv_profile을 리턴 해준다
        return iv_profile;
    }

    public void setIv_profile(int iv_profile) {
        this.iv_profile = iv_profile;
    }

    public String  getTv_name() {                                                                    // tv_name을 리턴 해준다
        return tv_name;
    }

    public void setTv_name(String  tv_name) {
        this.tv_name = tv_name;
    }

    public String  getTv_birth() {                                                                   // tv_birth을 리턴 해준다
        return tv_birth;
    }

    public void setTv_birth(String  tv_birth) {
        this.tv_birth = tv_birth;
    }
}
