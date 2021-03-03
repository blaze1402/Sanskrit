package com.blaze.sanskrit;

public class Word {

    private final String mDefaultTranslation;

    private final String mSanskritTranslation;

    private int mImageResourceID=0;

    public Word(String defaultTranslation, String sanskritTranslation) {
        mDefaultTranslation = defaultTranslation;
        mSanskritTranslation = sanskritTranslation;
    }

    public Word(String defaultTranslation, String sanskritTranslation, int imageResourceID) {
        mDefaultTranslation = defaultTranslation;
        mSanskritTranslation = sanskritTranslation;
        mImageResourceID = imageResourceID;
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
    public boolean hasImage(){
        return mImageResourceID!=0;
    }
}