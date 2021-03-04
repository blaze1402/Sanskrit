package com.blaze.sanskrit;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Array List of numbers in english, sanskrit and their audio file
        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("One", "ekam",R.drawable.number_one, R.raw.number_one));
        words.add(new Word("Two", "dve",R.drawable.number_two, R.raw.number_two));
        words.add(new Word("Three", "trīṇi",R.drawable.number_three, R.raw.number_three));
        words.add(new Word("Four", "catvāri",R.drawable.number_four, R.raw.number_four));
        words.add(new Word("Five", "pañca",R.drawable.number_five, R.raw.number_five));
        words.add(new Word("Six", "ṣaṭ",R.drawable.number_six, R.raw.number_six));
        words.add(new Word("Seven", "sapta",R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("Eight", "aṣṭa",R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("Nine", "nava",R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("Ten", "daśa",R.drawable.number_ten, R.raw.number_ten));

        WordAdapter adapter = new WordAdapter(this, words,R.color.category_numbers);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word=words.get(position);
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this,word.getAudioResourceID());
                mMediaPlayer.start();
            }
        });
    }
}