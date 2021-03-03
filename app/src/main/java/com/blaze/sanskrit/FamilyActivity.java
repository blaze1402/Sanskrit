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

        words.add(new Word("Mother", "Mātā",R.drawable.family_mother));
        words.add(new Word("Father", "Pitā",R.drawable.family_father));
        words.add(new Word("Daughter", "Putrī",R.drawable.family_daughter));
        words.add(new Word("Son", "Putraḥ",R.drawable.family_son));
        words.add(new Word("Aunt", "Pitṛvyā",R.drawable.family_aunt));
        words.add(new Word("Uncle", "Pitṛvyaḥ",R.drawable.family_uncle));
        words.add(new Word("Niece", "Bhrātṛjā",R.drawable.family_niece));
        words.add(new Word("Nephew", "Bhrātṛjāḥ",R.drawable.family_nephew));
        words.add(new Word("Grand Mother", "Pitāmahī",R.drawable.family_grandmother));
        words.add(new Word("Grand Father", "Pitāmahaḥ",R.drawable.family_grandfather));

        WordAdapter adapter = new WordAdapter(this, words,R.color.category_family);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}