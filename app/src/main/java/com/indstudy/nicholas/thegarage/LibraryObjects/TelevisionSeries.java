package com.indstudy.nicholas.thegarage.LibraryObjects;

import com.indstudy.nicholas.thegarage.LibraryObjects.FormatEnums.VideoFormat;

/**
 * Created by Nicholas on 12/2/2015.
 */
public class TelevisionSeries {

    private int itemId;
    private String userEmail;
    private String title;
    private int releaseYear;
    private String director;
    private int season;
    private VideoFormat format;
    private Boolean isWatched;
    private Boolean isWatching;
    private String link;

    public TelevisionSeries(){}

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

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public VideoFormat getFormat() {
        return format;
    }

    public void setFormat(VideoFormat format) {
        this.format = format;
    }

    public Boolean getWatched() {
        return isWatched;
    }

    public void setWatched(Boolean watched) {
        isWatched = watched;
    }

    public Boolean getWatching() {
        return isWatching;
    }

    public void setWatching(Boolean watching) {
        isWatching = watching;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
