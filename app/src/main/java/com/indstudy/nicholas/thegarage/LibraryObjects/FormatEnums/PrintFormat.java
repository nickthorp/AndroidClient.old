package com.indstudy.nicholas.thegarage.LibraryObjects.FormatEnums;

/**
 * Created by Nicholas on 10/19/2015.
 */
public enum PrintFormat {
    //Book formats
    PAPERBACK("Paperback"), HARDCOVER("Hardcover"), KINDLE("Kindle"), NOOK("Nook"), GOOGLE_PLAY("Google Play"), APPLE_STORE("Apple Store");

    private String friendlyName;

    private PrintFormat(String name) {
        this.friendlyName = name;
    }

    @Override
    public String toString() {
        return friendlyName;
    }
}
