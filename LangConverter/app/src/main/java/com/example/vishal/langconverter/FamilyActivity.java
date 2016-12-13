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

public class FamilyActivity extends AppCompatActivity {

    // Global variable for media player
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


        final ArrayList<Word> family = new ArrayList<>();
        family.add(new Word("әpә","Father",R.drawable.family_father,R.raw.family_father));
        family.add(new Word("әṭa","Mother",R.drawable.family_mother,R.raw.family_mother));
        family.add(new Word("angsi","Son",R.drawable.family_son,R.raw.family_son));
        family.add(new Word("tune","Daughter",R.drawable.family_daughter,R.raw.family_daughter));
        family.add(new Word("taachi","Older Brother",R.drawable.family_older_brother,R.raw.family_older_brother));
        family.add(new Word("chalitti","Younger Brother",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        family.add(new Word("teṭe","Older Sister",R.drawable.family_older_sister,R.raw.family_older_sister));
        family.add(new Word("kolliti","Younger Sister",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        family.add(new Word("ama","Grandmother",R.drawable.family_grandmother,R.raw.family_grandmother));
        family.add(new Word("paapa","Grandfather",R.drawable.family_grandfather,R.raw.family_grandfather));


        WordAdapter itemsAdapter = new WordAdapter(this,family,R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        // Create the listner method to listen the user click

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            // Here the position gives which position the user click on so we get the array item in the
            // wordlist and we access the audio file associate with the position
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Word fam = family.get(position);
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

                    mMediaPlayer = MediaPlayer.create(FamilyActivity.this, fam.getAudioId());
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
        }
    }
}
