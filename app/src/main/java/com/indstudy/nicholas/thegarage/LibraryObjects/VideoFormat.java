package com.indstudy.nicholas.thegarage.LibraryObjects;

/**
 * Created by Nicholas on 11/26/2015.
 */
public enum VideoFormat {
    //Video formats
    VHS("VHS"), DVD("DVD"), BLURAY("Blu-Ray"), GOOGLE_PLAY("Google Play"), APPLE_STORE("Apple Store");

    private String friendlyName;

    VideoFormat(String name) {
        this.friendlyName = name;
    }

    @Override
    public String toString() {
        return friendlyName;
    }
}
