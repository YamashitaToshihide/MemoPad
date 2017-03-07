package com.lifeistech.developer.hide.memopad;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> titleArray = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    HashMap<String, String> hashMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //contentsNumberというkeyで保存されているメモの数の情報を取得(例５）
        SharedPreferences pref = getSharedPreferences("MemoPad", MODE_PRIVATE);
        int contentsNumber = pref.getInt("contentsNumber", 0);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),NewMemoActivity.class);
                startActivity(intent);
            }
        });


        //for文でgetSharedPreferences("0～5",Mode_private)を呼んで、そのなかのkey_titleの情報をtitleArrayに追加する


        for (int i = 0; i < contentsNumber; i++) {
            SharedPreferences preferences = getSharedPreferences(String.valueOf(i), MODE_PRIVATE);
            String title = preferences.getString("key_title", "");
            titleArray.add(title);
        }

        listView = (ListView) findViewById(R.id.listView);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titleArray);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                MemoActivity.number = String.valueOf(position);
                Intent intent = new Intent(getApplicationContext(), MemoActivity.class);
                startActivity(intent);


            }
        });

        listView.setAdapter(adapter);
    }

    public void memo(View v) {
        Intent intent = new Intent(this, NewMemoActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onResume() {
        super.onResume();
        titleArray.clear();
        //contentsNumberというkeyで保存されているメモの数の情報を取得(例５）
        SharedPreferences pref = getSharedPreferences("MemoPad", MODE_PRIVATE);
        int contentsNumber = pref.getInt("contentsNumber", 0);


        //for文でgetSharedPreferences("0～5",Mode_private)を呼んで、そのなかのkey_titleの情報をtitleArrayに追加する


        for (int i = 0; i < contentsNumber; i++) {
            SharedPreferences preferences = getSharedPreferences(String.valueOf(i), MODE_PRIVATE);
            String title = preferences.getString("key_title", "");
            titleArray.add(title);
        }

        adapter.notifyDataSetChanged();
    }
}
