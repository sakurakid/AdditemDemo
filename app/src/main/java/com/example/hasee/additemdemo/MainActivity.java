package com.example.hasee.additemdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private String TAG = this.getClass().getSimpleName();
    private LinearLayout addHoteNameView;//转载所有的动态加载的Item

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addHoteNameView = (LinearLayout)findViewById(R.id.ll_addView);
        findViewById(R.id.btn_addData).setOnClickListener(this);

        addViewItem(null);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add://动态加载
                addViewItem(v);
                break;
            case R.id.btn_addData://打印数据
                Intent intent = new Intent(MainActivity.this,LayoutlinflateActivity.class);
                startActivity(intent);
                break;
        }

    }
    //添加ViewItem
    private void addViewItem(View view){
        if (addHoteNameView.getChildCount()==0){
            View hoteView = View.inflate(this,R.layout.item,null);
            Button additem = (Button)hoteView.findViewById(R.id.btn_add);
            additem.setText("+新增");
            additem.setTag("add");
            additem.setOnClickListener(this);
            addHoteNameView.addView(hoteView);
        }else if(((String)view.getTag()).equals("add")){
            View hoteView = View.inflate(this,R.layout.item,null);
            addHoteNameView.addView(hoteView);
            sortHoteViewItem();
        }
    }
    //item排序
    private void sortHoteViewItem(){
        //获取LinearLayout里面的所有的View
        for(int i = 0;i < addHoteNameView.getChildCount();i++){
            final View childAt = addHoteNameView.getChildAt(i);
            final Button btn_remove = (Button)childAt.findViewById(R.id.btn_add);
            btn_remove.setText("删除");
            btn_remove.setTag("remove");//设置删除标记
            btn_remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //删除当前的ViewItem
                    addHoteNameView.removeView(childAt);
                }
            });
            //如果是最后一个Viewitem,就设置为添加
            if (i==(addHoteNameView.getChildCount()-1)){
                Button btn_add = (Button)childAt.findViewById(R.id.btn_add);
                btn_add.setText("+新增");
                btn_add.setTag("add");
                btn_add.setOnClickListener(this);

            }
        }
    }
}
