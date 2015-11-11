package com.indstudy.nicholas.thegarage.LibraryObjects;

/**
 * Created by Nicholas on 10/23/2015.
 */
public class MovieTV {
    private String title;
    private int releaseYear;
    private String director;
    private Format format;
    private Boolean isWatching;

    public MovieTV(){}

    public MovieTV(String title, String director){
        this.title = title;
        this.director = director;
    }

    public MovieTV(String title, String director, int releaseYear){
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
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

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public Boolean getIsWatching() {
        return isWatching;
    }

    public void setIsWatching(Boolean isWatching) {
        this.isWatching = isWatching;
    }

    public String toString(){
        return title + " (" + releaseYear + ")";
    }
}
