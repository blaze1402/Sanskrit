package com.blaze.sanskrit;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class WordAdapter extends ArrayAdapter<Word> {
    private final int mcolorResourceID;

    public WordAdapter(@NonNull Activity context, ArrayList<Word> words, int colorResourceID) {
        super(context, 0, words);
        mcolorResourceID = colorResourceID;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentPosition = getItem(position);

        TextView defaultTranslation = listItemView.findViewById(R.id.default_text_view);
        defaultTranslation.setText(currentPosition.getDefaultTranslation());

        TextView sanskritTranslation = listItemView.findViewById(R.id.sanskrit_text_view);
        sanskritTranslation.setText(currentPosition.getSanskritTranslation());

        ImageView imageView = listItemView.findViewById(R.id.image);
        if (currentPosition.hasImage()) {
            imageView.setImageResource(currentPosition.getImageResourceID());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        listItemView.setBackgroundResource(mcolorResourceID);

        return listItemView;
    }
}
