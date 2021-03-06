package com.blaze.sanskrit;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class PhrasesFragment extends Fragment {

    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    private AudioAttributes mAudioAttributes;
    private int mAudioFocusRequest;
    private AudioFocusRequest mFocusRequest = null;

    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
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

            mAudioManager.abandonAudioFocusRequest(mFocusRequest);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);


        // get the audio system service for
        // the audioManger instance
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        // initiate the audio playback attributes
        mAudioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build();

        // set the playback attributes for the focus requester
        mFocusRequest = new AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN)
                .setAudioAttributes(mAudioAttributes)
                .setAcceptsDelayedFocusGain(true)
                .setOnAudioFocusChangeListener(mOnAudioFocusChangeListener)
                .build();

        // request the audio focus and
        // store it in the int variable
        mAudioFocusRequest = mAudioManager.requestAudioFocus(mFocusRequest);

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

        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_phrases);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                releaseMediaPlayer();
                if (mAudioFocusRequest == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(getActivity(), word.getAudioResourceID());
                    mMediaPlayer.start();
                    ImageView play = view.findViewById(R.id.play);
                    play.setImageResource(R.drawable.ic_pause);
                    mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            play.setImageResource(R.drawable.ic_play);
                            releaseMediaPlayer();
                        }
                    });
                }
            }
        });

        return rootView;
    }
}
