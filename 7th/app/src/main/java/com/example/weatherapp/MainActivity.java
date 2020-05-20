package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private ListView stringViewer;
    private ArrayList<String> stringArrayList = new ArrayList<>();
    private StringAdapter stringAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mContext = getApplicationContext();

        stringViewer = (ListView) findViewById(R.id.listviewer);
        stringArrayList.add("안녕하세요.");
        stringArrayList.add("저는 한양대학교 ERICA 캠퍼스");
        stringArrayList.add("소프트웨어학부 2019052851");
        stringArrayList.add("박준성이라고 합니다.");
        stringArrayList.add("ZOAC 1등!!!!!!!!!!");

        stringAdapter = new StringAdapter(mContext, stringArrayList);
        stringViewer.setAdapter(stringAdapter);
    }
}
