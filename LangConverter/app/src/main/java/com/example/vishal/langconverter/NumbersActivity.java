package com.example.vishal.langconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("lutti","One"));
        words.add(new Word("otiiko","Two"));
        words.add(new Word("tolookosu","Three"));
        words.add(new Word("oyissa","Four"));
        words.add(new Word("massokka","Five"));
        words.add(new Word("temmokka","Six"));
        words.add(new Word("kenekaku","Seven"));
        words.add(new Word("kawinta","Eight"));
        words.add(new Word("wo'e","Nine"));
        words.add(new Word("na'aacha","Ten"));


       ArrayAdapter<Word> itemsAdapter = new ArrayAdapter<Word>(this, R.layout.list_item, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);




    }
}
