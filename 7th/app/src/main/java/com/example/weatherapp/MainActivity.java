package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        stringAdapter = new StringAdapter(mContext, stringArrayList);
        stringViewer.setAdapter(stringAdapter);

        String content = "";
        FetchWeatherTask weatherTask = new FetchWeatherTask();
        try {
            String id = "1835847";
            content = weatherTask.execute("http://api.openweathermap.org/data/2.5/forecast/daily?id="+ id +"&mode=json&units=metric&cnt=7&appid=5fd2f2cde90c1533efb95b19c048a528").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Date today = new Date();
        System.out.println(today.getTime());
        JSONObject jsonMain = null;
        try {
            jsonMain = new JSONObject(content);
            JSONArray date = new JSONArray(jsonMain.getString("list"));
            int len = date.length();
            for (int i = 0 ; i < len ; i++) {
                JSONObject temp = date.getJSONObject(i).getJSONObject("temp");
                JSONArray weather = date.getJSONObject(i).getJSONArray("weather");
                double min = temp.getDouble("min");
                double max = temp.getDouble("max");
                long now_date_int = date.getJSONObject(i).getLong("dt")*1000;
                String wth = weather.getJSONObject(0).getString("main");
//                System.out.println(now_date_int);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd (E)");
                Date now = new Date(now_date_int);
//                System.out.println(sdf.format(today));
//                System.out.println(sdf.format(now));
                stringArrayList.add(sdf.format(now) + "\n" + wth +" \nlow : " + min + "             high : " + max);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
}
}
