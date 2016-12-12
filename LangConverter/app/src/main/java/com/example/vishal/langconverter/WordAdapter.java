package com.example.vishal.langconverter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vishal on 12/12/16.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Activity context, ArrayList<Word> words) {

    // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
    // Also the second argument is for single TextView but we have custom view so it is set to 0

    super(context,0,words);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Get the  current object located in the position
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml with the id miwok
        TextView mewokTextView = (TextView) listItemView.findViewById(R.id.mewok);

        //Get the mewok translation from current word object and set it on mewok TextView
        mewokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml with the id english
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.Default);

        // Get the default Translation from the current Word object and set it to default TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        //Find the ImageView in the list_item.xml with the id image
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        //We don't know that it has omage or not lets check that
        if (currentWord.hasImage()) {

            // Get the imageview from currentWord object and set it to our image
            imageView.setImageResource(currentWord.getImage_id());

            // Make sure the view is visible in case it is not previously
            imageView.setVisibility(View.VISIBLE);

        }

        else {

            // We can set the visibility of ImageView to GONE
            imageView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
