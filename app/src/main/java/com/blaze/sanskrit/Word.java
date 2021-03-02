package com.blaze.sanskrit;

public class Word {

    private final String mDefaultTranslation;

    private final String mSanskritTranslation;

    public Word(String defaultTranslation, String sanskritTranslation) {
        mDefaultTranslation = defaultTranslation;
        mSanskritTranslation = sanskritTranslation;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getSanskritTranslation() {
        return mSanskritTranslation;
    }
}