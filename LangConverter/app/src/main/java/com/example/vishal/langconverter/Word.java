package com.example.vishal.langconverter;

/**
 * Created by vishal on 12/12/16.
 */

public class Word {

    private static final int NO_WORD_PROVIDED = -1;

    private String mMiwok;
    private String mDefault;
    private int mImage_id = NO_WORD_PROVIDED;


    // Word Constructor to initialize the values specially for phrases

    public Word(String mi, String de){
        mMiwok = mi;
        mDefault = de;
    }

    // Word Constructor to initialize the values

    public Word(String mi, String de,int imgId){
        mMiwok = mi;
        mDefault = de;
        mImage_id = imgId;
    }

    // Get the Miwok Translation of the Word

    public String getMiwokTranslation(){
        return mMiwok;
    }

    // Get the Default Translation of the Word

    public String  getDefaultTranslation() {
        return  mDefault;
    }

    // Get the Image associate with the Word

    public int getImage_id() {
        return mImage_id;
    }

    // Check if there is an Image or not

    public boolean hasImage() {
        return mImage_id != NO_WORD_PROVIDED;
    }
}
