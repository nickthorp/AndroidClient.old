package com.indstudy.nicholas.thegarage;

/**
 * Created by Nicholas on 10/15/2015.
 */
public class User {
    private String email;
    private String firstName;
    private String lastName;
    private String userName;
//    private List<Friend> friends;  TODO: Add in Friend class

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
