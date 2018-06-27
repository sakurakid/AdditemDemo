package com.example.hasee.additemdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class LayoutlinflateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layoutlinflate);
        LinearLayout item = (LinearLayout)findViewById(R.id.ll_addView1);
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.additem_layout,null,false);
        //这个是将第一个xml布局添加到参数第二个View中
        item.addView(view);
    }
}
