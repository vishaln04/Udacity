package com.example.vishal.langconverter;

/**
 * Created by vishal on 12/12/16.
 */

public class Word {

    private String mMiwok;
    private String mDefault;

    // Word Constructior to initialize the values

    public Word(String mi, String de){
        mMiwok = mi;
        mDefault = de;
    }

    // Get the Miwok Translation of the Word

    public String getMiwokTranslation(){
        return mMiwok;
    }

    // Get the Default Translation of the Word

    public String  getDefaultTranslation() {
        return  mDefault;
    }
}
