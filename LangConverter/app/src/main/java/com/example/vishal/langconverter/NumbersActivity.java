package com.example.vishal.langconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<String> words = new ArrayList<>();
        words.add(0,"One");
        words.add(1,"Two");
        words.add(2,"Three");
        words.add(3,"Four");
        words.add(4,"Five");
        words.add(5,"Six");
        words.add(6,"Seven");
        words.add(7,"Eight");
        words.add(8,"Nine");
        words.add(9,"Ten");

       ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, words);

        GridView listView = (GridView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);




    }
}
