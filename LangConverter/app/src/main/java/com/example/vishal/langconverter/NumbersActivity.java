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

public class NumbersActivity extends AppCompatActivity {

    // Handles playback of all media files
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



        final ArrayList<Word> numbers = new ArrayList<>();
        numbers.add(new Word("lutti","One",R.drawable.number_one,R.raw.number_one));
        numbers.add(new Word("otiiko","Two",R.drawable.number_two,R.raw.number_two));
        numbers.add(new Word("tolookosu","Three",R.drawable.number_three,R.raw.number_three));
        numbers.add(new Word("oyissa","Four",R.drawable.number_four,R.raw.number_four));
        numbers.add(new Word("massokka","Five",R.drawable.number_five,R.raw.number_five));
        numbers.add(new Word("temmokka","Six",R.drawable.number_six,R.raw.number_six));
        numbers.add(new Word("kenekaku","Seven",R.drawable.number_seven,R.raw.number_seven));
        numbers.add(new Word("kawinta","Eight",R.drawable.number_eight,R.raw.number_eight));
        numbers.add(new Word("wo'e","Nine",R.drawable.number_nine,R.raw.number_nine));
        numbers.add(new Word("na'aacha","Ten",R.drawable.number_ten,R.raw.number_ten));


       WordAdapter itemsAdapter = new WordAdapter(this,numbers,R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        // Create the listner method to listen the user click

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            // Here the position gives which position the user click on so we get the array item in the
            // wordlist and we access the audio file associate with the position
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Word number = numbers.get(position);
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


                    mMediaPlayer = MediaPlayer.create(NumbersActivity.this, number.getAudioId());
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
