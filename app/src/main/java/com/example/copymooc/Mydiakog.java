package com.example.copymooc;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

/**
 * Created by asus1 on 2018/1/6.
 */

public class Mydiakog extends Dialog {
    NumberPicker np1=(NumberPicker)findViewById(R.id.np_year);
        NumberPicker no2=(NumberPicker)findViewById(R.id.np_month);
    NumberPicker np3=(NumberPicker)findViewById(R.id.np_day);
    public Mydiakog(@NonNull Context context) {
        super(context,R.style.myDialog);
        setContentView(R.layout.time);
    }
}
