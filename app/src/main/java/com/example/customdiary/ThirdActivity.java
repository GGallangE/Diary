package com.example.customdiary;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.nio.file.Files;

public class ThirdActivity extends AppCompatActivity {
    DBHelper helper;
    SQLiteDatabase db;
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        TextView listview = findViewById(R.id.listview);
        Intent list = getIntent();
        message = list.getStringExtra("write");
        listview.setText(message);




    }
}
