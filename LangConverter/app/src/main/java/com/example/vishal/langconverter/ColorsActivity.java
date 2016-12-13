package com.example.vishal.langconverter;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT;
import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK;

public class ColorsActivity extends AppCompatActivity {

    // Global variable for mediaplayer
    MediaPlayer mMediaPlayer;

    // Declare global audiomanager variable for handling audio focus
    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener afChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        // We temporarily loss the focus or ducking the other apps
                        // Pause playback
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        // We regain the focus
                        // Resume playback
                        mMediaPlayer.start();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        // We loss the focus completely and we have to release the resources
                        // Stop playback
                        releaseMediaPlayer();
                    }
                }
            };

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

        // Create and setup the audiomanager to request audio focus

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);


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

                // Request audio focus for playback
                int result = mAudioManager.requestAudioFocus(afChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    // We have our Audio focus now

                    mMediaPlayer = MediaPlayer.create(ColorsActivity.this, color.getAudioId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);

                }

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

            // Abandon audio focus when playback complete, we can add it in onstop and oncomplete method but
            // both are calling our helper method so it is appropriate to add it here
            mAudioManager.abandonAudioFocus(afChangeListener);
        }
    }
}
