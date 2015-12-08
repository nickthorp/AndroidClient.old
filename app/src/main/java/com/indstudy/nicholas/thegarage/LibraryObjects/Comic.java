package com.indstudy.nicholas.thegarage.LibraryObjects;

import com.indstudy.nicholas.thegarage.LibraryObjects.FormatEnums.PrintFormat;

/**
 * Created by Nicholas on 10/23/2015.
 */
public class Comic {
    private int itemId;
    private String userEmail;
    private String title;
    private String author;
    private String artist;
    private int volume;
    private String publisher;
    private PrintFormat format;
    private Boolean isRead;
    private Boolean isReading;

    public Comic(){
    }

    public Comic(String title, String author){
        this.title = title;
        this.author = author;
    }

    public Comic(String title, String author, PrintFormat format, Boolean isReading){
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

    public PrintFormat getFormat() {
        return format;
    }

    public void setFormat(PrintFormat format) {
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

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }
}
