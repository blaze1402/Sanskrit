package com.blaze.sanskrit;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Array List of numbers in english and sanskrit
        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("One", "ekam",R.drawable.number_one));
        words.add(new Word("Two", "dve",R.drawable.number_two));
        words.add(new Word("Three", "trīṇi",R.drawable.number_three));
        words.add(new Word("Four", "catvāri",R.drawable.number_four));
        words.add(new Word("Five", "pañca",R.drawable.number_five));
        words.add(new Word("Six", "ṣaṭ",R.drawable.number_six));
        words.add(new Word("Seven", "sapta",R.drawable.number_seven));
        words.add(new Word("Eight", "aṣṭa",R.drawable.number_eight));
        words.add(new Word("Nine", "nava",R.drawable.number_nine));
        words.add(new Word("Ten", "daśa",R.drawable.number_ten));

        WordAdapter adapter = new WordAdapter(this, words);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}