package com.example.vishalnagarale.justjava;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
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
       CheckBox checkBox_chocolate = (CheckBox) findViewById(R.id.checkbox_chocolate);
        EditText name = (EditText) findViewById(R.id.user_name);
        String u_name = name.getText().toString();
        u_name = getResources().getString(R.string.just_order) + u_name;
        String message = createOrderSummary(Quantity,u_name,checkBox_whipped_cream.isChecked(), checkBox_chocolate.isChecked());

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{""});
        i.putExtra(Intent.EXTRA_SUBJECT, u_name);
        i.putExtra(Intent.EXTRA_TEXT   , message);
        try {
            startActivity(Intent.createChooser(i, getResources().getString(R.string.sendmail)));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, getResources().getString(R.string.noclients), Toast.LENGTH_SHORT).show();
        }

//
//       displayMessage(message);
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
            Toast.makeText(context, getResources().getString(R.string.toast), Toast.LENGTH_SHORT).show();
        else
            Quantity -= 1;
        quantityTextView.setText("" + Quantity);
    }

    // Creates an order summary
    private String createOrderSummary(int number, String name, boolean checkbox, boolean checkbox_choco){
        String message;
        if (!checkbox && !checkbox_choco)
            message = getResources().getString(R.string.username) + " : " + name + "\n" + getResources().getString(R.string.quantity) + " : "+ number + "\n"+ getResources().getString(R.string.total) + " : " + number*5 + "\n" + getResources().getString(R.string.tq);
        else if (checkbox && !checkbox_choco)
            message = getResources().getString(R.string.username) + " : " + name + "\n" + getResources().getString(R.string.with) + getResources().getString(R.string.whi_cream) + "\n" + getResources().getString(R.string.quantity) + " : "+ number + "\n"+ getResources().getString(R.string.total) + " : " + number*6 + "\n" + getResources().getString(R.string.tq);
        else if (!checkbox && checkbox_choco)
            message = getResources().getString(R.string.username) + " : " + name + "\n" + getResources().getString(R.string.with) + getResources().getString(R.string.chocolate) + "\n" + getResources().getString(R.string.quantity) + " : "+ number + "\n"+ getResources().getString(R.string.total) + " : " + number*7 + "\n" + getResources().getString(R.string.tq);
        else
            message = getResources().getString(R.string.username) + " : " + name + "\n" + getResources().getString(R.string.with) + getResources().getString(R.string.whi_cream) + "&" + getResources().getString(R.string.chocolate) + "\n" + getResources().getString(R.string.quantity) + " : "+ number + "\n"+ getResources().getString(R.string.total) + " : " + number*8 + "\n" + getResources().getString(R.string.tq);
        return message;
    }

}
