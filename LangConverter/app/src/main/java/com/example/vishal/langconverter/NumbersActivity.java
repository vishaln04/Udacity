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
        numbers.add(new Word("lutti","One",R.drawable.number_one));
        numbers.add(new Word("otiiko","Two",R.drawable.number_two));
        numbers.add(new Word("tolookosu","Three",R.drawable.number_three));
        numbers.add(new Word("oyissa","Four",R.drawable.number_four));
        numbers.add(new Word("massokka","Five",R.drawable.number_five));
        numbers.add(new Word("temmokka","Six",R.drawable.number_six));
        numbers.add(new Word("kenekaku","Seven",R.drawable.number_seven));
        numbers.add(new Word("kawinta","Eight",R.drawable.number_eight));
        numbers.add(new Word("wo'e","Nine",R.drawable.number_nine));
        numbers.add(new Word("na'aacha","Ten",R.drawable.number_ten));


       WordAdapter itemsAdapter = new WordAdapter(this,numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);




    }
}
