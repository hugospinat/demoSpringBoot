package com.example.demo;

import java.util.*;

class User {
    private String name;
    private String firstName;
    private Date birthDate;

    public User() {
        name = "";
        firstName = "";
        birthDate = new Date();
    }

    public User(String name, String firstName, Date birthDate) {
        this.name = name;
        this.firstName = firstName;
        this.birthDate = birthDate;
    }

    // getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}