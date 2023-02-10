package com.example.customdiary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity{
    CalendarView calendarView;
    TextView today;
    TextView text;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        today = findViewById(R.id.day_text);
        calendarView = findViewById(R.id.calenderView);
        text = findViewById(R.id.text);
        button = findViewById(R.id.btn);

        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd", Locale.getDefault());
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM", Locale.getDefault());
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy", Locale.getDefault());
        String date_text = yearFormat.format(currentTime) + "년" + monthFormat.format(currentTime) + "월"
                + dayFormat.format(currentTime) + "일";
        DateFormat formatter = new SimpleDateFormat("yyyy년MM월dd일");
        Date date = new Date(calendarView.getDate());
        today.setText(formatter.format(date));
        String a = "aaa";
        long now = System.currentTimeMillis();
        Date date1 = new Date(now);
        calendarView.setMaxDate(date1.getTime());
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String day;
                day = year + "년" + (month+1) + "월" + dayOfMonth + "일";
                today.setText(day);
                text.setText(date_text);
                button.setVisibility(View.VISIBLE);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(a == "aaa"){
                            Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                            intent.putExtra("day",day);
                            startActivity(intent);
                        }

                    }
                });
            }
        });

    }
}
