package com.blaze.sanskrit;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Array List of Colors in english and sanskrit
        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("Black", "kṛṣṇaḥ"));
        words.add(new Word("Blue", "nīlaḥ"));
        words.add(new Word("Brown", "pāhataḥ"));
        words.add(new Word("Green", "haritaḥ"));
        words.add(new Word("Orange", "pītaraktaḥ"));
        words.add(new Word("Pink", "pāṭalaḥ"));
        words.add(new Word("Purple", "nīlalōhita"));
        words.add(new Word("Red", "raktaḥ"));
        words.add(new Word("White", "śvetaḥ"));
        words.add(new Word("Yellow", "pītaḥ"));

        WordAdapter adapter = new WordAdapter(this, words);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}