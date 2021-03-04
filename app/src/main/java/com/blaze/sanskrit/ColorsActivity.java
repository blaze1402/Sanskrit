package com.blaze.sanskrit;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

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

        //Array List of Colors in english, sanskrit and their audio file
        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("Black", "kṛṣṇaḥ", R.drawable.color_black, R.raw.color_black));
        words.add(new Word("Blue", "nīlaḥ", R.drawable.color_blue, R.raw.color_blue));
        words.add(new Word("Brown", "pāhataḥ", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("Green", "haritaḥ", R.drawable.color_green, R.raw.color_green));
        words.add(new Word("Orange", "pītaraktaḥ", R.drawable.color_orange, R.raw.color_orange));
        words.add(new Word("Pink", "pāṭalaḥ", R.drawable.color_pink, R.raw.color_pink));
        words.add(new Word("Purple", "nīlalōhita", R.drawable.color_purple, R.raw.color_purple));
        words.add(new Word("Red", "raktaḥ", R.drawable.color_red, R.raw.color_red));
        words.add(new Word("White", "śvetaḥ", R.drawable.color_white, R.raw.color_white));
        words.add(new Word("Yellow", "pītaḥ", R.drawable.color_yellow, R.raw.color_yellow));

        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudioResourceID());
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