package com.example.copymooc;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus1 on 2018/1/6.
 */

public class Time extends Dialog implements NumberPicker.OnValueChangeListener,NumberPicker.OnScrollListener,NumberPicker.Formatter{

    private NumberPicker np_year;
    private NumberPicker np_month;
    private NumberPicker np_day;
    private TextView tv_title;
    static String month,year,day;
    static int new_year=1,new_month=1,new_day=1;
    String a[]={"January","February","三月","四月","May","June","July","August","November","December",
            "十一月","十二月"};
    public Time(@NonNull Context context) {
        super(context);
        setContentView(R.layout.time);
        init();
    }
    private void init() {
        np_year = (NumberPicker) findViewById(R.id.np_year);
        np_month = (NumberPicker) findViewById(R.id.np_month);
        np_day = (NumberPicker) findViewById(R.id.np_day);
        tv_title=(TextView)findViewById(R.id.tv_date);
        np_day.setOnValueChangedListener(this);
        np_day.setOnScrollListener(this);
        np_day.setMaxValue(31);
        np_day.setMinValue(1);
        np_day.setValue(1);
        //天
        np_year.setOnValueChangedListener(this);
        np_year.setOnScrollListener(this);
        np_year.setMaxValue(2018);
        np_year.setMinValue(1900);
        np_year.setValue(1900);
        //年
        np_month.setOnValueChangedListener(this);
        np_month.setOnScrollListener(this);
        np_month.setDisplayedValues(a);
        np_month.setMaxValue(11);
        np_month.setMinValue(0);
//        np_month.setValue(0);
        //月
    }
    public String format(int value) {
        String tmpStr = String.valueOf(value);
        if (value < 10) {
            tmpStr = "0" + tmpStr;
        }
        return tmpStr;
    }
    @Override
    public void onScrollStateChange(NumberPicker view, int scrollState) {
        switch (scrollState) {
            case android.widget.NumberPicker.OnScrollListener.SCROLL_STATE_FLING:
//                Toast.makeText(view.getContext(), "后续滑动(飞呀飞，根本停下来)", Toast.LENGTH_LONG)
//                        .show();
                break;
            case android.widget.NumberPicker.OnScrollListener.SCROLL_STATE_IDLE:
//                Toast.makeText(view.getContext(), "不滑动", Toast.LENGTH_LONG).show();
                break;
            case android.widget.NumberPicker.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
//                Toast.makeText(view.getContext(), "滑动中", Toast.LENGTH_LONG)
//                        .show();

                break;
        }
    }

    @Override
    public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
//        Toast.makeText(numberPicker.getContext(), "原来的值 " + oldVal + "--新值: "
//                        + newVal, Toast.LENGTH_SHORT).show();
        new_month=np_month.getValue();
        month=a[new_month];
        Log.d("测试",month);
        new_day=np_day.getValue();
        new_year=np_year.getValue();
        tv_title.setText(month+"."+new_day+","+new_year);
    }
}
