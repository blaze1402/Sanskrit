package com.blaze.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Opens Numbers List activity
    public void openNumbersList(View view) {
        startActivity(new Intent(this, NumbersActivity.class));
    }

    //Opens Family Members List activity
    public void openFamilyMembersList(View view) {
        startActivity(new Intent(this, FamilyActivity.class));
    }

    //Opens Colors List activity
    public void openColorsList(View view) {
        startActivity(new Intent(this, ColorsActivity.class));
    }

    //Opens Phrases List activity
    public void openPhrasesList(View view) {
        startActivity(new Intent(this, PhrasesActivity.class));
    }
}