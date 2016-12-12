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
        colors.add(new Word("әpә","Father",R.drawable.family_father));
        colors.add(new Word("әṭa","Mother",R.drawable.family_mother));
        colors.add(new Word("angsi","Son",R.drawable.family_son));
        colors.add(new Word("tune","Daughter",R.drawable.family_daughter));
        colors.add(new Word("taachi","Older Brother",R.drawable.family_older_brother));
        colors.add(new Word("chalitti","Younger Brother",R.drawable.family_younger_brother));
        colors.add(new Word("teṭe","Older Sister",R.drawable.family_older_sister));
        colors.add(new Word("kolliti","Younger Sister",R.drawable.family_younger_sister));
        colors.add(new Word("ama","Grandmother",R.drawable.family_grandmother));
        colors.add(new Word("paapa","Grandfather",R.drawable.family_grandfather));


        WordAdapter itemsAdapter = new WordAdapter(this,colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

    }
}
