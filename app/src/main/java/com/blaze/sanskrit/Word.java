package com.blaze.sanskrit;

public class Word {

    private final String mDefaultTranslation;

    private final String mSanskritTranslation;

    private int mImageResourceID = 0;

    private final int mAudioResourceID;

    public Word(String defaultTranslation, String sanskritTranslation, int audioResourceID) {
        mDefaultTranslation = defaultTranslation;
        mSanskritTranslation = sanskritTranslation;
        mAudioResourceID = audioResourceID;
    }

    public Word(String defaultTranslation, String sanskritTranslation, int imageResourceID, int audioResourceID) {
        mDefaultTranslation = defaultTranslation;
        mSanskritTranslation = sanskritTranslation;
        mImageResourceID = imageResourceID;
        mAudioResourceID = audioResourceID;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getSanskritTranslation() {
        return mSanskritTranslation;
    }

    public int getImageResourceID() {
        return mImageResourceID;
    }

    public boolean hasImage() {
        return mImageResourceID != 0;
    }

    public int getAudioResourceID() {
        return mAudioResourceID;
    }
}