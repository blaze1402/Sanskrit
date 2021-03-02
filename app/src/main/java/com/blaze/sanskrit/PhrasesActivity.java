package com.blaze.sanskrit;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Array List of phrases in english and sanskrit
        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("Good morning", "Śuprabhātam"));
        words.add(new Word("Is there a market nearby?", "Kiṁ āpaṇaṁ samīpē asti."));
        words.add(new Word("Where is the nearest bank?", "Sarva samīpaṁ kaḥ vittakōṣaḥ asti"));
        words.add(new Word("I have to check in my bags.", "Mama syūtāḥ nirikṣaṇa karaṇīyam."));
        words.add(new Word("How much is insurance?", "Tasya vinimayaḥ kiyata asti."));
        words.add(new Word("I need to see a doctor.", "Mahyaṁ cikitsakāt milaniyaḥ."));
        words.add(new Word("I need to make a phone call.", "Mahyaṁ dūravāṇī karaṇīyam."));
        words.add(new Word("It's raining outside.", "Atra vahiḥ vr̥ṣṭiḥ bhavati"));
        words.add(new Word("Is there any restaurant nearby?", "Atra samīpē kō'api bhōjanālayaḥ asti."));
        words.add(new Word("Is there a first aid box?", "Kiṁ atra prāthamika aupacāra pēṭikā asti"));

        WordAdapter adapter = new WordAdapter(this, words);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}