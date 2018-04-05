package com.example.android.miwok;

import android.widget.ImageView;

/**
 * Created by mf on 15/03/2018.
 */

public class Word {
    // Miwok translation for the word
    private String mMiwokTranslation;

    // Default tanslation for the word
    private String mDefaultTranslation;

    // Image Resource ID for the word
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    private int mAudioResourceId;

    // Create a new Word object.
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId,int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    // Get the miwok tanslation of the word
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    // Get the miwok tanslation of the word
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    // Return the image Resource id of the word
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     *  Returns whether or not there is an image for this word
     */
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    // Get audio resource id of the word
    public int getAudioResourceId() {
        return mAudioResourceId;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioResourceId=" + mAudioResourceId +
                '}';
    }

}
