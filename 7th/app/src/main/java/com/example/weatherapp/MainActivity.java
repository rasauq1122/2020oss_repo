package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

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

        String content;
        FetchWeatherTask weatherTask = new FetchWeatherTask();
        try {
            String id = "1835847";
            content = weatherTask.execute("http://api.openweathermap.org/data/2.5/forecast/daily?id="+ id +"&mode=json&units=metric&cnt=7&appid=5fd2f2cde90c1533efb95b19c048a528").get();
            System.out.println(content);
            Log.i("content", content);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
