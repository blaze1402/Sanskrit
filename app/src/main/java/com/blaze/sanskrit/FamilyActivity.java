package com.blaze.sanskrit;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Array List of Family Members in english and sanskrit
        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("Mother", "Mātā"));
        words.add(new Word("Father", "Pitā"));
        words.add(new Word("Daughter", "Putrī"));
        words.add(new Word("Son", "Putraḥ"));
        words.add(new Word("Aunt", "Pitṛvyā"));
        words.add(new Word("Uncle", "Pitṛvyaḥ"));
        words.add(new Word("Niece", "Bhrātṛjā"));
        words.add(new Word("Nephew", "Bhrātṛjāḥ"));
        words.add(new Word("Grand Mother", "Pitāmahī"));
        words.add(new Word("Grand Father", "Pitāmahaḥ"));

        WordAdapter adapter = new WordAdapter(this, words);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}