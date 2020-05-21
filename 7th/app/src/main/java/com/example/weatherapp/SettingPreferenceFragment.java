package com.example.weatherapp;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class    SettingPreferenceFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
