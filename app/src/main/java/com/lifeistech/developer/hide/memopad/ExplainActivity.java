package com.lifeistech.developer.hide.memopad;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ExplainActivity extends AppCompatActivity {

    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explain);
        SharedPreferences pref=getSharedPreferences("key_tutorial", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putBoolean("key_tutorial",true);
        editor.commit();
    }
}
