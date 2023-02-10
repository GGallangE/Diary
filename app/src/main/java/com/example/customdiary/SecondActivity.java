package com.example.customdiary;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{
    EditText write;
    Button home;
    Button save;
    Button read;
    TextView day;
    DBHelper dbHelper;
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Date currentTime = Calendar.getInstance().getTime();
        home = findViewById(R.id.home_btn);
        save = findViewById(R.id.save_btn);
        day = findViewById(R.id.day);
        write = findViewById(R.id.write);
        read = findViewById(R.id.read_btn);
        Intent today = getIntent();
        message = today.getStringExtra("day");
        day.setText(message+" 일기 쓰기");
        home.setOnClickListener(this);
        read.setOnClickListener(this);
        save.setOnClickListener(this);
        dbHelper = new DBHelper(SecondActivity.this, 2);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.save_btn:
                dbHelper.insert(message,write.getText().toString());
                break;
            case R.id.read_btn:
                Intent detail = new Intent(getApplicationContext(),ThirdActivity.class);
                detail.putExtra("write",dbHelper.getResult());
                startActivity(detail);
                break;
            case R.id.home_btn:
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
