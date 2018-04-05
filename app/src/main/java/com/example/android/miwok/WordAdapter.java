package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by mf on 16/03/2018.
 */

public class WordAdapter extends ArrayAdapter<Word> {


    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words,int ColorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mColorResourceId = ColorResourceId;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID default_text_view
        TextView defaultTranslationTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the DefaultTranslation from the current Word object and
        // set this text on the DefaultTranslation TextView
        defaultTranslationTextView.setText(currentWord.getDefaultTranslation());

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view
        TextView miwokTranslationTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the Miwok translation from the current Word object and
        // set this text on the miwokTranslation TextView
        miwokTranslationTextView.setText(currentWord.getMiwokTranslation());

        // Find the ImageView in the list_item.xml layout with the ID image
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Get the image resource ID from the current Word object and
        // set the image to iconView

        if(currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());

            imageView.setVisibility(View.VISIBLE);
        }
        else{
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        //Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        return listItemView;


    }



}
