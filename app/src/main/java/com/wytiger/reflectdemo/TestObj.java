package com.wytiger.reflectdemo;

import android.util.Log;

/**
 * description ：
 * author : wuyong_cd
 * date : 2019/10/11 0011 16:34
 */
public class TestObj {
    private String s;

    public TestObj(String s) {
        this.s = s;
    }

    private void display(String s2) {
        Log.d("Reflect", s2);
    }

    @Override
    public String toString() {
        return "TestObj{" +
                "s='" + s + '\'' +
                '}';
    }
}
