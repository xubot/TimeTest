package com.example.xykf.test;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.xykf.mylibrary.WheelPicker.picker.DatePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Calendar calendar = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void onYearMonthDayPicker(View view) {
        DatePicker picker = new DatePicker(this);
        picker.setCancelText("时间选择框");
        picker.setCancelTextColor(Color.RED);
        picker.setSubmitText("确认");
        picker.setSubmitTextColor(Color.BLUE);
        picker.setRange(2000, 2030);
        picker.setSelectedItem(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
        picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
            @Override
            public void onDatePicked(String year, String month, String day) {
                showToast(year + "-" + month + "-" + day);
            }
        });
        picker.show();
    }
}
