package com.example.vishal.langconverter;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    // Global variable for mediaplayer
    MediaPlayer mMediaPlayer;

    // This listner get triggered when the Mediaplayer has completed playing the audio file

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> colors = new ArrayList<>();
        colors.add(new Word("weṭeṭṭi","Red",R.drawable.color_red,R.raw.color_red));
        colors.add(new Word("chokokki","Green",R.drawable.color_green,R.raw.color_green));
        colors.add(new Word("ṭakaakki","Brown",R.drawable.color_brown,R.raw.color_brown));
        colors.add(new Word("ṭopoppi","Gray",R.drawable.color_gray,R.raw.color_gray));
        colors.add(new Word("kululli","Black",R.drawable.color_black,R.raw.color_black));
        colors.add(new Word("kelelli","White",R.drawable.color_white,R.raw.color_white));
        colors.add(new Word("ṭopiisә","Dusty Yellow",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        colors.add(new Word("chiwiiṭә","Mustard Yellow",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));


        WordAdapter itemsAdapter = new WordAdapter(this,colors,R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        // Create the listner method to listen the user click

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            // Here the position gives which position the user click on so we get the array item in the
            // wordlist and we access the audio file associate with the position
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Word color = colors.get(position);
                // Release the media player if it currently exist because we are about to play new song
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, color.getAudioId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });

    }

    // In case the activity stop then we have to release the resources

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    // Release Media Player Resources
    private void releaseMediaPlayer() {
        // If the media player is not null then release the resource and make the object to be null
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}
