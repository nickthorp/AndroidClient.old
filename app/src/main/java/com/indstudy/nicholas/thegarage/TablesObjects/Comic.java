package com.indstudy.nicholas.thegarage.TablesObjects;

/**
 * Created by Nicholas on 10/23/2015.
 */
public class Comic {
    private String title;
    private String author;
    private String artist;
    private Format format;
    private Boolean isReading;

    public Comic(){
    }

    public Comic(String title, String author){
        this.title = title;
        this.author = author;
    }

    public Comic(String title, String author, Format format, Boolean isReading){
        this.title = title;
        this.author = author;
        this.format = format;
        this.isReading = isReading;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public Boolean getIsReading() {
        return isReading;
    }

    public void setIsReading(Boolean isReading) {
        this.isReading = isReading;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String toString(){
        return title + " by " + author;
    }
}
