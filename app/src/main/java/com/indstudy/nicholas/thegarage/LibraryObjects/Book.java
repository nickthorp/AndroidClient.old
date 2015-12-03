package com.indstudy.nicholas.thegarage.LibraryObjects;

/**
 * Created by Nicholas on 10/19/2015.
 */
public class Book {
    private int itemId;
    private String userEmail;
    private String title;
    private String author;
    private String publisher;
    private int edition;
    private String isbn;
    private PrintFormat format;
    private Boolean isRead;
    private Boolean isReading;
    private String link;

    public Book(){
    }

    public Book(int itemId, String userEmail, String title){
        this.itemId = itemId;
        this.userEmail = userEmail;
        this.title = title;
        this.isReading = false;
        this.isRead = false;
    }

    public Book(String title, String author, PrintFormat format, Boolean isReading){
        this.title = title;
        this.author = author;
        this.format = format;
        this.isReading = isReading;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getEdition() {

        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setFormat(PrintFormat format) {
        this.format = format;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public Boolean getIsReading() {
        return isReading;
    }

    public void setIsReading(Boolean isReading) {
        this.isReading = isReading;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String toString() {
        return title + " by " + (author != null ? author : "Unknown");
    }
}
