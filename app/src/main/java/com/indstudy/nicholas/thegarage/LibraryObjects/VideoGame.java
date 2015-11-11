package com.indstudy.nicholas.thegarage.LibraryObjects;

/**
 * Created by Nicholas on 10/24/2015.
 */
public class VideoGame {
    private String title;
    private Platform platform;
    private Boolean isPlaying;
    private String developer;

    public VideoGame(){
    }

    public VideoGame(String title){
        this.title = title;
    }

    public VideoGame(String title, Platform platform){
        this.title = title;
        this.platform = platform;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public Boolean getIsPlaying() {
        return isPlaying;
    }

    public void setIsPlaying(Boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String toString(){
        return title + " (" + platform + ")";
    }
}
