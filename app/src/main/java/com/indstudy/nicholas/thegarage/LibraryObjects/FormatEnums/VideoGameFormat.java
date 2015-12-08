package com.indstudy.nicholas.thegarage.LibraryObjects.FormatEnums;

/**
 * Created by Nicholas on 10/24/2015.
 */
public enum VideoGameFormat {
    //Consoles and Platforms
    PS3("PlayStation 3"), XBOX360("XBox 360"), XBONE("XBox One"), PS4("PlayStation 4"), PC("PC"), STEAM("Steam");

    private String friendlyName;

    VideoGameFormat(String name) {
        this.friendlyName = name;
    }

    @Override
    public String toString() {
        return friendlyName;
    }
}
