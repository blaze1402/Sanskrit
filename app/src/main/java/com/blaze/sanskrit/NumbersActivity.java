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

        words.add(new Word("One", "ekam"));
        words.add(new Word("Two", "dve"));
        words.add(new Word("Three", "trīṇi"));
        words.add(new Word("Four", "catvāri"));
        words.add(new Word("Five", "pañca"));
        words.add(new Word("Six", "ṣaṭ"));
        words.add(new Word("Seven", "sapta"));
        words.add(new Word("Eight", "aṣṭa"));
        words.add(new Word("Nine", "nava"));
        words.add(new Word("Ten", "daśa"));

        WordAdapter adapter = new WordAdapter(this, words);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}