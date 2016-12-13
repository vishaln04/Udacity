package com.example.vishal.langconverter;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    // Global variable for media player
    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

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
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, fam.getAudioId());
                mMediaPlayer.start();
            }
        });

    }
}
