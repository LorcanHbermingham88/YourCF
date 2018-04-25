package com.example.lorcan.yourcf.Model;

/**
 * Created by Lorcan on 07/03/2018.
 */

public class User {

    private String Email;
    private String FirstName;
    private String LastName;
    private String Password;
    private String Phone;

    public User() {
    }

    public User(String email, String firstName, String lastName, String password) {
        Email = email;
        FirstName = firstName;
        LastName = lastName;
        Password = password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
