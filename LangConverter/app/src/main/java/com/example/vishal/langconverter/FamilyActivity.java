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

        ArrayList<Word> family = new ArrayList<>();
        family.add(new Word("әpә","Father",R.drawable.family_father));
        family.add(new Word("әṭa","Mother",R.drawable.family_mother));
        family.add(new Word("angsi","Son",R.drawable.family_son));
        family.add(new Word("tune","Daughter",R.drawable.family_daughter));
        family.add(new Word("taachi","Older Brother",R.drawable.family_older_brother));
        family.add(new Word("chalitti","Younger Brother",R.drawable.family_younger_brother));
        family.add(new Word("teṭe","Older Sister",R.drawable.family_older_sister));
        family.add(new Word("kolliti","Younger Sister",R.drawable.family_younger_sister));
        family.add(new Word("ama","Grandmother",R.drawable.family_grandmother));
        family.add(new Word("paapa","Grandfather",R.drawable.family_grandfather));


        WordAdapter itemsAdapter = new WordAdapter(this,family,R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

    }
}
