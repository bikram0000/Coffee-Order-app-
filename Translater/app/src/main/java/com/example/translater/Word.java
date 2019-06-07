package com.example.translater;

public class Word {

    /**
     * Default translation for the word
     */
    private String mDefaultTranslation;

    /**
     * odiya translation for the word
     */
    private String mOdiyaTranslation;

    //image icon view
    private Integer mimageForAll = NO_IMAGE_VIEW;

    private static final int NO_IMAGE_VIEW = -1;
    //for audio file
    private int mAudioResourseId ;

    /**
     * Create a new com.example.translater.Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param odiyaTranslation   the word in the odiya language
     */
    public Word(String defaultTranslation, String odiyaTranslation, Integer imageForAll,int audioResourseId) {
        mDefaultTranslation = defaultTranslation;
        mOdiyaTranslation = odiyaTranslation;
        mimageForAll = imageForAll;
        mAudioResourseId = audioResourseId ;
    }
    //for Phrases Activity .........

    public Word(String defaultTranslation, String odiyaTranslation, int audioResourseId) {
        mDefaultTranslation = defaultTranslation;
        mOdiyaTranslation = odiyaTranslation;
        mAudioResourseId = audioResourseId ;
    }

    /**
     * Get the default translation of the word.
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }
    /**
     * Get the odiya translation of the word.
     */
    public String getOdiyaTranslation() {
        return mOdiyaTranslation;
    }

    public Integer getimageForAll() {
        return mimageForAll;
    }

    public boolean hasImage() {
        return mimageForAll != NO_IMAGE_VIEW;
    }
    public int getmAudioResourseId(){
        return mAudioResourseId;
    }

}
