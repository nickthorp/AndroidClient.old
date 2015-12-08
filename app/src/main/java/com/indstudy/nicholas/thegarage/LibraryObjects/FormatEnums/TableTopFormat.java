package com.indstudy.nicholas.thegarage.LibraryObjects.FormatEnums;

/**
 * Created by Nicholas on 10/24/2015.
 */
public enum TableTopFormat {
    //Table Top formats
    CARDS("Card Game"), TRADING_CARDS("Trading Cards"), BOARD_GAME("Board Game");

    private String friendlyName;

    TableTopFormat(String name) {
        this.friendlyName = name;
    }

    @Override
    public String toString() {
        return friendlyName;
    }
}
