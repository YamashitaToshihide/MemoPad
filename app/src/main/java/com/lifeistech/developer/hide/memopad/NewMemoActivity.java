package com.lifeistech.developer.hide.memopad;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NewMemoActivity extends AppCompatActivity {

    EditText titleEditText;
    EditText contentEditText;
    SharedPreferences pref2;
    SharedPreferences pref;
    int contentsNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);


        pref = getSharedPreferences("MemoPad",MODE_PRIVATE);
        contentsNumber = pref.getInt("contentsNumber",0);

        pref2 = getSharedPreferences(String.valueOf(contentsNumber),MODE_PRIVATE);


        titleEditText=(EditText)findViewById(R.id.title);
        contentEditText=(EditText)findViewById(R.id.content);

    }
    public void save(View v){
        String titleText=titleEditText.getText().toString();
        String contentText=contentEditText.getText().toString();

        if(!(titleText.equals(""))) {
            SharedPreferences.Editor editor2 = pref2.edit();

            editor2.putString("key_title", titleText);
            editor2.putString("key_content", contentText);
            editor2.commit();

            SharedPreferences.Editor editor = pref.edit();
            editor.putInt("contentsNumber", contentsNumber + 1);
            editor.commit();

        }

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
