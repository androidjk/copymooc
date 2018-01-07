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
    static int teshu_month,teshu_year;
    static int new_year=1,new_month=1,new_day=1;
    static int zhou;
    String a[]={"January","February","March","April","May","June","July","August","September","October",
            "November","December"};
    String b[]={"Sun.","Mon.","Tue.","Wed.","Thur.","Fri.","Sta."};
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
        month=a[np_month.getValue()];
        new_day=np_day.getValue();
        new_year=np_year.getValue();
        calculateWeek();
        tv_title.setText(b[zhou]+","+month+"."+new_day+","+new_year);
    }
    public void calculateWeek(){
        if (new_month==0){
            teshu_month=12;
            teshu_year=new_year-1;
        }else if (new_month==1){
            teshu_month=1;
            teshu_year=new_year-1;
        }else {
            teshu_month=new_month;
            teshu_year=new_year;
        }
        zhou=teshu_year%100+teshu_year%100/4+teshu_year/100/4-2*(new_year/100)+26*(teshu_month+2)/10+new_day-1;
        if (zhou<0){
            zhou=0-zhou;
        }
        zhou=zhou%7;
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
        switch (new_month){
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
                np_day.setMaxValue(31);
                np_day.setMinValue(1);
                break;
            case 1:
                if ((new_year%4==0&&new_year%100!=0)||(new_year%4==0&&new_year%400==0)){
                    np_day.setMaxValue(29);
                    np_day.setMinValue(1);
                }else {
                    np_day.setMaxValue(28);
                    np_day.setMinValue(1);
                }
                break;
            case 3:
            case 5:
            case 8:
            case 10:
                np_day.setMaxValue(30);
                np_day.setMinValue(1);
                break;
            default:
                break;
        }
        calculateWeek();
        tv_title.setText(b[zhou]+","+month+"."+new_day+","+new_year);
    }
}
