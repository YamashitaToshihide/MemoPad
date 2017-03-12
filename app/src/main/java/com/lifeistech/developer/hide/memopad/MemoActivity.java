package com.lifeistech.developer.hide.memopad;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MemoActivity extends AppCompatActivity {

    EditText titleEditText;
    EditText contentEditText;
    SharedPreferences pref;
    static String number = "-1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);
        titleEditText=(EditText)findViewById(R.id.title);
        contentEditText=(EditText)findViewById(R.id.content);

        pref=getSharedPreferences(number,MODE_PRIVATE);

        titleEditText.setText(pref.getString("key_title",""));
        contentEditText.setText(pref.getString("key_content",""));
    }
    public void save(View v){
        String titleText=titleEditText.getText().toString();
        String contentText=contentEditText.getText().toString();

        SharedPreferences.Editor editor=pref.edit();
        editor.putString("key_title",titleText);
        editor.putString("key_content",contentText);
        editor.commit();


        finish();
    }

    public void deleat(View v){
        String titleText=titleEditText.getText().toString();
        String contentText=contentEditText.getText().toString();

        if(!(titleText.equals(""))) {
            SharedPreferences.Editor editor = pref.edit();
            editor.remove("key_title");
            editor.remove("key_content");
            editor.commit();
        }
        finish();
    }
}
