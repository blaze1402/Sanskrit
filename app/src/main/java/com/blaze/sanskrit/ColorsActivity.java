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

        words.add(new Word("Black", "kṛṣṇaḥ",R.drawable.color_black));
        words.add(new Word("Blue", "nīlaḥ",R.drawable.color_blue));
        words.add(new Word("Brown", "pāhataḥ",R.drawable.color_brown));
        words.add(new Word("Green", "haritaḥ",R.drawable.color_green));
        words.add(new Word("Orange", "pītaraktaḥ",R.drawable.color_orange));
        words.add(new Word("Pink", "pāṭalaḥ",R.drawable.color_pink));
        words.add(new Word("Purple", "nīlalōhita",R.drawable.color_purple));
        words.add(new Word("Red", "raktaḥ",R.drawable.color_red));
        words.add(new Word("White", "śvetaḥ",R.drawable.color_white));
        words.add(new Word("Yellow", "pītaḥ",R.drawable.color_yellow));

        WordAdapter adapter = new WordAdapter(this, words,R.color.category_colors);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}