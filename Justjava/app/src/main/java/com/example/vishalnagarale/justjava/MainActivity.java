package com.example.vishalnagarale.justjava;

import android.content.Context;
import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
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
       CheckBox checkBox_whipped_cream = (CheckBox) findViewById(R.id.checkbox_whipped_cream);
       boolean chbox_w_cream = checkBox_whipped_cream.isChecked();
        String message = createOrderSummary(Quantity,chbox_w_cream);
       displayMessage(message);
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

    // Creates an order summary
    private String createOrderSummary(int number, boolean checkbox){
        String message;
        if (checkbox = false)
            message = "Name : Kaptain Kunal\nQuantity : "+ number + "\nTotal : " + number*5 + "\nThank You!";
        else
            message = "Name : Kaptain Kunal \nwith Whipped Cream \nQuantity : "+ number + "\nTotal : " + number*5 + "\nThank You!";
        return message;
    }

    // Dispaly message
    private void displayMessage(String message){
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(message);
    }
}
