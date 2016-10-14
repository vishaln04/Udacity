package com.example.vishalnagarale.justjava;

import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view){
        display(2);
        displayPrice(2*5);
    }

    // Display Number of Cups of coffee
    private void display(int number){
        TextView quantityTextView = (TextView)findViewById(R.id.value);
        quantityTextView.setText("" + number);
    }

    // Display total price of coffee
    private void displayPrice(int number){
        TextView priceTextView = (TextView)findViewById(R.id.pvalue);
        priceTextView.setText("$" + number);
    }
}
