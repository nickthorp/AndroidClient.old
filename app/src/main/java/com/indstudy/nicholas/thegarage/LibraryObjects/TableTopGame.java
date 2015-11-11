package com.indstudy.nicholas.thegarage.LibraryObjects;

/**
 * Created by Nicholas on 10/24/2015.
 */
public class TableTopGame {
    private String gameTitle;
    private int minPlayers;
    private int maxPlayers;
    private TableTopStyle style;

    public TableTopGame() {
    }

    public TableTopGame(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public TableTopStyle getStyle() {
        return style;
    }

    public void setStyle(TableTopStyle style) {
        this.style = style;
    }

    public String toString(){
        return gameTitle;
    }
}
