package com.indstudy.nicholas.thegarage.TablesObjects;

import java.util.ArrayList;

/**
 * Created by Nicholas on 10/15/2015.
 */
public class User {
    private String email;
    private String firstName;
    private String lastName;
    private String userName;
//    private ArrayList<Friend> friends;  TODO: Add in Friend class
    private ArrayList<Book> books;
    private ArrayList<Comic> comics;
    private ArrayList<MovieTV> shows;
    private ArrayList<Music> music;
    private ArrayList<TableTopGame> tableTopGames;
    private ArrayList<VideoGame> videoGames;


    public User(){
    }

    public String getEmail(){ return email; }
    public String getFirstName(){ return firstName; }
    public String getLastName(){ return lastName; }
    public String getUserName(){ return userName; }

    public void setEmail(String email){ this.email = email; }
    public void setFirstName(String firstName){ this.firstName = firstName; }
    public void setLastName(String lastName){ this.lastName = lastName; }
    public void setUserName(String userName){ this.userName = userName; }
}
