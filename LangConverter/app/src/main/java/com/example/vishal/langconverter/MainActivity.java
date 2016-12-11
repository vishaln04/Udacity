package com.example.vishal.langconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Find the view that shows number category
        TextView numbers = (TextView) findViewById(R.id.numbers);

        // Set clickListener on the view
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Number_intent = new Intent(MainActivity.this,NumbersActivity.class);
                startActivity(Number_intent);
            }
        });

        // Find the view that shows Family Members Category
        TextView family = (TextView) findViewById(R.id.family);

        // Set clickListener on the view
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent family_intent = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(family_intent);
            }
        });

        // Find the view that shows Colors Category
        TextView colors = (TextView) findViewById(R.id.colors);

        // Set clickListener on the view
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent colors_intent = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity(colors_intent);
            }
        });

        // Find the view that shows Phrases Category
        TextView phrases = (TextView) findViewById(R.id.phrases);

        // Set clickListener on the view
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phrases_intent = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(phrases_intent);
            }
        });

    }

}
