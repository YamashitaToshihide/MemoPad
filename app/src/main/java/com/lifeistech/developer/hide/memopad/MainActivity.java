package com.lifeistech.developer.hide.memopad;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    boolean isFirst=true;

    int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref=getSharedPreferences("key_tutorial",Context.MODE_PRIVATE);
        isFirst=pref.getBoolean("key_tutorial",true);

        if (isFirst){
            Intent intent=new Intent(this,ExplainActivity.class);
            startActivity(intent);
            SharedPreferences pref2=getSharedPreferences("key_tutorial", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=pref2.edit();
            editor.putBoolean("key_tutorial",false);
            editor.commit();
        }

    }

    public void memo(View v){
        Intent intent=new Intent(this,MemoActivity.class);
        startActivity(intent);
    }
}
