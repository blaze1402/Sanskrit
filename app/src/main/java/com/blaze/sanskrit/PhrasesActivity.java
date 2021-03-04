package com.blaze.sanskrit;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private final MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

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

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResourceID());
                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(onCompletionListener);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}