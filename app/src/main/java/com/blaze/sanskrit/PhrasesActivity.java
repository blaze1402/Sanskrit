package com.blaze.sanskrit;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Array List of phrases in english, sanskrit and their audio file
        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("Good morning", "Śuprabhātam",
                R.raw.phrases_goodmorning));
        words.add(new Word("Is there a market nearby?", "Kiṁ āpaṇaṁ samīpē asti.",
                R.raw.phrases_isthereamarketnearby));
        words.add(new Word("Where is the nearest bank?", "Sarva samīpaṁ kaḥ vittakōṣaḥ asti",
                R.raw.phrases_whereisthenearestbank));
        words.add(new Word("I have to check in my bags.", "Mama syūtāḥ nirikṣaṇa karaṇīyam.",
                R.raw.phrases_ihavetocheckinmybags));
        words.add(new Word("How much is insurance?", "Tasya vinimayaḥ kiyata asti.",
                R.raw.phrases_howmuchisinsurance));
        words.add(new Word("I need to see a doctor.", "Mahyaṁ cikitsakāt milaniyaḥ.",
                R.raw.phrases_ineedtoseeadoctor));
        words.add(new Word("I need to make a phone call.", "Mahyaṁ dūravāṇī karaṇīyam.",
                R.raw.phrases_ineedtomakeaphonecall));
        words.add(new Word("It's raining outside.", "Atra vahiḥ vr̥ṣṭiḥ bhavati",
                R.raw.phrases_itsrainingoutside));
        words.add(new Word("Is there any restaurant nearby?", "Atra samīpē kō'api bhōjanālayaḥ asti.",
                R.raw.phrases_isthereanyrestaurantnearby));
        words.add(new Word("Is there a first aid box?", "Kiṁ atra prāthamika aupacāra pēṭikā asti",
                R.raw.phrases_isthereafirstaidbox));

        WordAdapter adapter = new WordAdapter(this, words,R.color.category_phrases);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word=words.get(position);
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this,word.getAudioResourceID());
                mMediaPlayer.start();
            }
        });
    }
}