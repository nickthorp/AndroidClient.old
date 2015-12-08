package com.indstudy.nicholas.thegarage.LibraryObjects.FormatEnums;

/**
 * Created by Nicholas on 12/3/2015.
 */
public enum AudioFormat {
    //Audio formats
    CASSETTE("Cassette"), CD("CD"), VINYL("Vinyl"), GOOGLE_PLAY("Google Play"), ITUNES("ITunes");

    private String friendlyName;

    AudioFormat(String name) {
        this.friendlyName = name;
    }

    @Override
    public String toString() {
        return friendlyName;
    }
}
