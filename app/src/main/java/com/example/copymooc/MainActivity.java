package com.example.copymooc;

import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MenuItem item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        item=menu.findItem(R.id.menu_test);
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Toast.makeText(MainActivity.this, "ceshi", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        return true;
    }
    public void myclick(int id){
       switch (id){
           case R.id.menu_color:
               showNormalDialog();
               break;
       }


    }
    public void showNormalDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setNegativeButton("取消",null)
                .setPositiveButton("确定",null)
                .setMessage("请选择")
                .setNeutralButton("怎么显示",null).show();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_color:
                myclick(R.id.menu_color);
                Toast.makeText(this, "改变颜色", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_size:
                Toast.makeText(this,"改变字体大小",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
