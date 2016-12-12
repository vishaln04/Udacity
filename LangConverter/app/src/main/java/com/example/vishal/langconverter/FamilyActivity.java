package com.example.vishal.langconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> colors = new ArrayList<>();
        colors.add(new Word("әpә","Father"));
        colors.add(new Word("әṭa","Mother"));
        colors.add(new Word("angsi","Son"));
        colors.add(new Word("tune","Daughter"));
        colors.add(new Word("taachi","Older Brother"));
        colors.add(new Word("chalitti","Younger Brother"));
        colors.add(new Word("teṭe","Older Sister"));
        colors.add(new Word("kolliti","Younger Sister"));
        colors.add(new Word("ama","Grandmother"));
        colors.add(new Word("paapa","Grandfather"));


        WordAdapter itemsAdapter = new WordAdapter(this,colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

    }
}
