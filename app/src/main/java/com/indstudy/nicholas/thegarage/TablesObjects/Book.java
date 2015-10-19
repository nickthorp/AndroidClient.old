package com.indstudy.nicholas.thegarage.TablesObjects;

/**
 * Created by Nicholas on 10/19/2015.
 */
public class Book {
    private String title;
    private String author;
    private Format format;
    private Boolean isReading;

    public Book(){
    }

    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    public Book(String title, String author, Format format, Boolean isReading){
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

    public String toString(){
        return title + " by " + author;
    }
}
