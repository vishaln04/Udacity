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
        colors.add(new Word("weṭeṭṭi","Red",R.drawable.color_red));
        colors.add(new Word("chokokki","Green",R.drawable.color_green));
        colors.add(new Word("ṭakaakki","Brown",R.drawable.color_brown));
        colors.add(new Word("ṭopoppi","Gray",R.drawable.color_gray));
        colors.add(new Word("kululli","Black",R.drawable.color_black));
        colors.add(new Word("kelelli","White",R.drawable.color_white));
        colors.add(new Word("ṭopiisә","Dusty Yellow",R.drawable.color_dusty_yellow));
        colors.add(new Word("chiwiiṭә","Mustard Yellow",R.drawable.color_mustard_yellow));


        WordAdapter itemsAdapter = new WordAdapter(this,colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);


    }
}
