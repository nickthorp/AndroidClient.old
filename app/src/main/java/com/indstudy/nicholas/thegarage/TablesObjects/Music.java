package com.indstudy.nicholas.thegarage.TablesObjects;

import android.media.Image;

import java.util.ArrayList;

/**
 * Created by Nicholas on 10/24/2015.
 */
public class Music {
    private String artistName;
    private String albumTitle;
    private ArrayList<String> songTitles;
    private Image albumArt;
    private Boolean isListening;

    public Music(){}

    public Music(String albumTitle, String artistName){
        this.albumTitle = albumTitle;
        this.artistName = artistName;
    }

    private void numberSongTitles(){
        for(int i = 0; i < songTitles.size()-1; i++)
            songTitles.set(i, i + ": " + songTitles.get(i));
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public ArrayList<String> getSongTitles() {
        numberSongTitles();
        return songTitles;
    }

    public void setSongTitles(ArrayList<String> songTitles) {
        this.songTitles = songTitles;
    }

    public Image getAlbumArt() {
        return albumArt;
    }

    public void setAlbumArt(Image albumArt) {
        this.albumArt = albumArt;
    }

    public Boolean getIsListening() {
        return isListening;
    }

    public void setIsListening(Boolean isListening) {
        this.isListening = isListening;
    }

    public String toString(){
        return albumTitle + " by " + artistName;
    }
}
