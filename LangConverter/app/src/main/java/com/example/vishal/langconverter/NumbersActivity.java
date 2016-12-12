package com.example.vishal.langconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> numbers = new ArrayList<>();
        numbers.add(new Word("lutti","One"));
        numbers.add(new Word("otiiko","Two"));
        numbers.add(new Word("tolookosu","Three"));
        numbers.add(new Word("oyissa","Four"));
        numbers.add(new Word("massokka","Five"));
        numbers.add(new Word("temmokka","Six"));
        numbers.add(new Word("kenekaku","Seven"));
        numbers.add(new Word("kawinta","Eight"));
        numbers.add(new Word("wo'e","Nine"));
        numbers.add(new Word("na'aacha","Ten"));


       WordAdapter itemsAdapter = new WordAdapter(this,numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);




    }
}
