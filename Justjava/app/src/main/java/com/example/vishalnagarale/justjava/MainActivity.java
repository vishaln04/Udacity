package com.example.vishalnagarale.justjava;

import android.content.Context;
import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public int Quantity = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        display(Quantity);
        displayPrice(Quantity * 5);
    }

    // Display Number of Cups of coffee
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.value);
        quantityTextView.setText("" + number);
    }

    // Display total price of coffee
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.pvalue);
        priceTextView.setText("" + number);
    }

    // increment function
    public void increment(View view) {
        Quantity += 1;
        TextView quantityTextView = (TextView) findViewById(R.id.value);
        quantityTextView.setText("" + Quantity);
    }

    // decrement function
    public void decrement(View view) {
        Context context = getApplicationContext();
        TextView quantityTextView = (TextView) findViewById(R.id.value);
        if (Quantity == 0)
            Toast.makeText(context, "Cannot decremented", Toast.LENGTH_SHORT).show();
        else
            Quantity -= 1;
        quantityTextView.setText("" + Quantity);
    }
}
