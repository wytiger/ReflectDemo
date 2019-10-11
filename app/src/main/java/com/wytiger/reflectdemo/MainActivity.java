package com.wytiger.reflectdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testReflect();
            }
        });
    }

    private void testReflect() {
        try {
            Class clazz = Class.forName("com.wytiger.reflectdemo.TestObj");

            //构造方法
            Constructor constructor = clazz.getConstructor(String.class);
            Object testObj = constructor.newInstance("hello");
            Log.d("Reflect", "testObj = " + testObj);

            //普通方法
            Method displayMethod = clazz.getDeclaredMethod("display", String.class);
            displayMethod.setAccessible(true);
            displayMethod.invoke(testObj, "world");

            //属性
            Field sField = clazz.getDeclaredField("s");
            sField.setAccessible(true);
            //获取
            String s = (String) sField.get(testObj);
            Log.d("Reflect", "s = " + s);
            //设置
            sField.set(testObj, "hi");
            String ss = (String) sField.get(testObj);
            Log.d("Reflect", "s = " + ss);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
