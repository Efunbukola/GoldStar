package com.goldstar;

public class UserAccount {
    String email, password, name, school, city;

    public UserAccount()
    {
        this.email = " ";
        this.password = " ";
        this.name = " ";
        this.school = " ";
        this.city = " ";
    }

    public UserAccount(String email, String password, String name, String school, String city)
    {
        this.email = email;
        this.password = password;
        this.name = name;
        this.school = school;
        this.city = city;
    }
}
