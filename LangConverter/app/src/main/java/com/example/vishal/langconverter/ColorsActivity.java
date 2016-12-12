package com.example.vishal.langconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> colors = new ArrayList<>();
        colors.add(new Word("weṭeṭṭi","Red"));
        colors.add(new Word("chokokki","Green"));
        colors.add(new Word("ṭakaakki","Brown"));
        colors.add(new Word("ṭopoppi","Gray"));
        colors.add(new Word("kululli","Black"));
        colors.add(new Word("kelelli","White"));
        colors.add(new Word("ṭopiisә","Dusty Yellow"));
        colors.add(new Word("chiwiiṭә","Mustard Yellow"));


        WordAdapter itemsAdapter = new WordAdapter(this,colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);


    }
}
