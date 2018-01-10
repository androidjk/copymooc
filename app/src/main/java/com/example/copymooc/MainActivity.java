package com.example.copymooc;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.SingleLineTransformationMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{
//    private Button bt_time;
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        initViews();
//        bt_time.setOnClickListener(this);
    }

    private void initViews() {
//        bt_time=(Button)findViewById(R.id.bt_time);
    }

    @Override
    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.bt_time:
//                Time time=new Time(this);
//                time.show();
//                break;
//        }
    }
}
